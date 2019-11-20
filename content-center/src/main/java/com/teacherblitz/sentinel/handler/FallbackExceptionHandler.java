package com.teacherblitz.sentinel.handler;

import lombok.extern.slf4j.Slf4j;

/**
 * sentinel降级处理类
 * @author teacherblitz
 * @since 2019/11/3 22:06
 */
@Slf4j
public class FallbackExceptionHandler {

    /**
     * 降级
     * @param a
     * @param e
     * @return
     */
    public static String fallback(String a, Throwable e){
        log.warn("限流，或者被降级了,fallback",e);
        return "限流，或者被降级了,fallback";
    }

    /**
     * 测试方法2
     * @param a
     * @param e
     * @return
     */
    public static String fallback2(String a, Throwable e){
        log.warn("限流，或者被降级了,fallback2",e);
        return "限流，或者被降级了,fallback2";
    }
}
