package com.teacherblitz.controller;

import com.teacherblitz.entity.TUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类
 * @author teacherblitz
 * @since 2019/11/24
 */
@Slf4j
@RestController
@RequestMapping("/tests/")
@RequiredArgsConstructor
public class TestController {

    /**
     * 测试方法
     * @param tUser
     * @return
     */
    @RequestMapping("/test-get")
    public TUser getUser(@RequestBody TUser tUser){
        return tUser;
    }

}
