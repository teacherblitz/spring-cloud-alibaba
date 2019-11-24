package com.teacherblitz.rocketmq;

import com.alibaba.fastjson.JSON;
import com.teacherblitz.domain.dto.content.UserAuditDTO;
import com.teacherblitz.service.ShareService;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * rocketmq本地事务
 * @author zhuyuan
 * @since 2019-11-23
 */
@RocketMQTransactionListener(txProducerGroup = "tx-add-bonus-group")
@RequiredArgsConstructor
public class AddBonusTransactionListener implements RocketMQLocalTransactionListener {

    private final ShareService shareService;

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        MessageHeaders headers = msg.getHeaders();

        String transactionId = (String) headers.get(RocketMQHeaders.TRANSACTION_ID);
        Integer shareId = Integer.valueOf((String) headers.get("user_id"));
        // 注意:在header里面接受的参数都是字符串，此处需要用json传递，做反序列化
        String dtoString = (String) headers.get("dto");
        UserAuditDTO auditDTO = JSON.parseObject(dtoString, UserAuditDTO.class);

        try {
            // 省略添加消息日志
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        MessageHeaders headers = msg.getHeaders();
        String transactionId = (String) headers.get(RocketMQHeaders.TRANSACTION_ID);

        // 省略查询该消息日志是否存在
        String transactionLog = transactionId;
        if (transactionLog != null) {
            return RocketMQLocalTransactionState.COMMIT;
        }
        return RocketMQLocalTransactionState.ROLLBACK;
    }
}
