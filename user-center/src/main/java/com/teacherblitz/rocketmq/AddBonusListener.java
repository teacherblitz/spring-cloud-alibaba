package com.teacherblitz.rocketmq;

import com.teacherblitz.domain.dto.messaging.UserAddBonusMsgDTO;
import com.teacherblitz.entity.TUser;
import com.teacherblitz.mapper.TUserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author teacherblitz
 * @since 2019/11/18
 */
@Service
@RequiredArgsConstructor
@RocketMQMessageListener(consumerGroup = "test-group", topic = "add-bonus")
public class AddBonusListener implements RocketMQListener<UserAddBonusMsgDTO> {

    private final TUserMapper tUserMapper;

    @Override
    public void onMessage(UserAddBonusMsgDTO message) {
        Integer userId = message.getUserId();
        Integer bonus = message.getBonus();
        TUser user = tUserMapper.selectById(userId);
        user.setBonus(user.getBonus() + bonus);
        // 添加积分
        tUserMapper.updateById(user);
    }
}
