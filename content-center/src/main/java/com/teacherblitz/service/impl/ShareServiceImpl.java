package com.teacherblitz.service.impl;

import com.alibaba.fastjson.JSON;
import com.teacherblitz.domain.dto.content.UserAuditDTO;
import com.teacherblitz.domain.dto.messaging.UserAddBonusMsgDTO;
import com.teacherblitz.domain.enums.AuditStatusEnum;
import com.teacherblitz.entity.TUser;
import com.teacherblitz.mapper.TUserMapper;
import com.teacherblitz.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

/**
 * @author teacherblitz
 * @since 2019/11/14
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ShareServiceImpl implements ShareService {

    private final TUserMapper tUserMapper;
    private final RocketMQTemplate rocketMQTemplate;
    private final Source source;

    @Override
    public TUser queryAuditById(Integer id, UserAuditDTO auditDto) {
        TUser user = this.tUserMapper.selectById(id);
        if(null == user){
            throw new IllegalArgumentException("参数非法!该用户不存在!");
        }
        if(!Objects.equals("NOT_YET", user.getAuditStatus())){
            throw new IllegalArgumentException("参数非法！该用户已审核通过或驳回！");
        }

        if(!AuditStatusEnum.PASS.equals(auditDto.getAuditStatusEnum())){
            String transactionId = UUID.randomUUID().toString();
            this.source.output()
                    .send(
                        MessageBuilder.withPayload(
                            UserAddBonusMsgDTO.builder()
                                .userId(user.getId())
                                .bonus(50)
                                .build()
                        )
                        .setHeader(RocketMQHeaders.TRANSACTION_ID, transactionId)
                        .setHeader("user_id", user.getId())
                        .setHeader("dto", JSON.toJSONString(auditDto))
                        .build()
                    );
        }else{
            this.auditByIdInDB(id, auditDto);
        }
        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    public void auditByIdInDB(Integer id, UserAuditDTO auditDTO){
        TUser user = TUser.builder()
                .id(id)
                .auditStatus(auditDTO.getAuditStatusEnum().toString())
                .reason(auditDTO.getReason())
                .build();
        this.tUserMapper.updateById(user);
    }
}
