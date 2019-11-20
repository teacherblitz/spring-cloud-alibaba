package com.teacherblitz.feignclient;

import com.teacherblitz.entity.TUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description 测试feign client
 * @author teacherblitz
 * @date 2019/10/20 21:41
 * @version v1.0
 */
@FeignClient("user-center")
public interface TestUserCenterFeignClient {

    @RequestMapping("/test-get")
    TUser getUserInfo(@SpringQueryMap TUser tUser);
}
