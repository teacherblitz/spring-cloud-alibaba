package com.teacherblitz.service.impl;

import com.teacherblitz.domain.dto.content.UserAuditDTO;
import com.teacherblitz.domain.dto.messaging.UserAddBonusMsgDTO;
import com.teacherblitz.entity.TUser;
import com.teacherblitz.mapper.TUserMapper;
import com.teacherblitz.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    @Override
    public TUser queryAuditById(Integer id, UserAuditDTO auditDto) {
        TUser user = this.tUserMapper.selectById(id);
        if(null == user){
            throw new IllegalArgumentException("参数非法!该用户不存在!");
        }
        if(!Objects.equals("NOT_YET", user.getAuditStatus())){
            throw new IllegalArgumentException("参数非法！该用户已审核通过或驳回！");
        }
        user.setAuditStatus(auditDto.getAuditStatusEnum().toString());
        this.tUserMapper.updateById(user);
        // 为该用户增加积分
        this.rocketMQTemplate.convertAndSend("add-bonus",
                UserAddBonusMsgDTO.builder()
                        .userId(user.getId())
                        .bonus(50)
                        .build());
        return user;
    }
}
