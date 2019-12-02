package com.teacherblitz.auth;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 检查用户登陆的切面
 * @author teacherblitz
 * @since 2019/11/30
 */
@Aspect
@Component
public class CheckLoginAspect {

    @Around("@annotation(com.teacherblitz.auth.CheckLogin)")
    public Object checkLogin(ProceedingJoinPoint point) throws Throwable {
        // 启动目标方法执行
        return point.proceed();
    }
}
