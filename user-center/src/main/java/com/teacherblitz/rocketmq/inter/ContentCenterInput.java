package com.teacherblitz.rocketmq.inter;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 创建接口，通过@Input注解绑定消息接收的Binding，
 * 接口方法的返回类型为SubscribableChannel，
 * 可以用来订阅消息，
 * 需要注意的是@Input注解的内容必须与配置文件中bingdings中配置的名称一致
 *
 * @author: <a href="mailto:teacherblitz@gmail.com">Teacher</a>
 * @since: 2022/12/8
 */
public interface ContentCenterInput {

    /**
     * 添加积分
     * @return
     */
    @Input("add-bonus-input")
    SubscribableChannel addBonusInput();
}
