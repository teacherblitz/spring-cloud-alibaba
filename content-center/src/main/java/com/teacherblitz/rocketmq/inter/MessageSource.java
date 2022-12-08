package com.teacherblitz.rocketmq.inter;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 消息输出binding接口
 *
 * @author: <a href="mailto:teacherblitz@gmail.com">Teacher</a>
 * @since: 2022/12/8
 */
public interface MessageSource {

    /**
     * 添加积分
     * @return
     */
    @Output("add-bonus-output")
    MessageChannel addBonusOutput();
}
