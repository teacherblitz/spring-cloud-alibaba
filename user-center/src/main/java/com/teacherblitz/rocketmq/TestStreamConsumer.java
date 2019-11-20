package com.teacherblitz.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

/**
 * 接收消息
 * @author teacherblitz
 * @since 2019/11/20
 */
@Slf4j
@Service
public class TestStreamConsumer {

    @StreamListener(Sink.INPUT)
    public void receive(String messageBody){
        log.info("通过stream收到了消息：messageBody = {}", messageBody);
    }
}
