package com.teacherblitz.rocketmq;

import com.teacherblitz.domain.dto.messaging.UserAddBonusMsgDTO;
import com.teacherblitz.service.ITUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * stream-rocketmq接收消息
 * @author teacherblitz
 * @since 2019/11/20
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AddBonusStreamConsumer {

    private final ITUserService userService;

    @StreamListener("add-bonus-input")
    public void receive(UserAddBonusMsgDTO msgDTO){
        log.info("通过stream收到了消息：messageBody = {}", msgDTO);
        this.userService.addBonus(msgDTO);
    }
}
