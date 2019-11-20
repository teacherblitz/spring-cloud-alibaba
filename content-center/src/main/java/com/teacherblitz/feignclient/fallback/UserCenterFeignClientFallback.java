package com.teacherblitz.feignclient.fallback;

import com.teacherblitz.entity.TUser;
import com.teacherblitz.feignclient.UserCenterFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author teacherblitz
 * @since 2019/11/7
 */
@Component
public class UserCenterFeignClientFallback implements UserCenterFeignClient {

    @Override
    public TUser findById(Integer userId) {
        TUser user = new TUser();
        user.setNickname("www.teacherblitz.com");
        return user;
    }
}
