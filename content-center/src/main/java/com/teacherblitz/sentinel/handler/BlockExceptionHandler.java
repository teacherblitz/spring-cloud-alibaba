package com.teacherblitz.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * sentinel限流处理类
 * @author teacherblitz
 * @since 2019/11/3 22:01
 */
@Slf4j
public class BlockExceptionHandler {

    /**
     * 处理限流或者降级
     * @param a
     * @param e
     * @return
     */
    public static String block(String a, BlockException e) {
        log.warn("限流，或者被降级了,block", e);
        return "限流，或者被降级了,block";
    }

    /**
     * 测试方法2
     * @param a
     * @param e
     * @return
     */
    public static String block2(String a, BlockException e) {
        log.warn("限流，或者被降级了,block2", e);
        return "限流，或者被降级了,block2";
    }

}
