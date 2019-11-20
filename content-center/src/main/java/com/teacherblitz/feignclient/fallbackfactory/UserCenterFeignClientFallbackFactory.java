package com.teacherblitz.feignclient.fallbackfactory;

import com.teacherblitz.entity.TUser;
import com.teacherblitz.feignclient.UserCenterFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 可以知道具体异常的类
 * @author teacherblitz
 * @since 2019/11/7
 */
@Slf4j
@Component
public class UserCenterFeignClientFallbackFactory implements FallbackFactory<UserCenterFeignClient> {

    @Override
    public UserCenterFeignClient create(Throwable throwable) {
        log.warn("服务被降级或限流了", throwable);
        return UserCenterFeignClient->{
            TUser user = new TUser();
            user.setNickname("www.teacherblitz.com");
            return user;
        };
    }
}
