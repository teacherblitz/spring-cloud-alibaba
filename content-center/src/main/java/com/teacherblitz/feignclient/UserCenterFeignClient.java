package com.teacherblitz.feignclient;

import com.teacherblitz.entity.TUser;
import com.teacherblitz.feignclient.fallbackfactory.UserCenterFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户中心Feign客户端
 * @author teacherblitz
 * @since 2019/10/19 15:05
 */
@FeignClient(name = "user-center",
//        fallback = UserCenterFeignClientFallback.class)
        fallbackFactory = UserCenterFeignClientFallbackFactory.class)
public interface UserCenterFeignClient {

    /**
     * http://user-center/getUserInfo/1
     * @param userId
     * @return
     */
    @GetMapping("/getUserInfo/{id}")
    TUser findById(@PathVariable("id") Integer userId);
}
