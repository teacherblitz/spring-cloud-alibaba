package com.teacherblitz.controller;

import com.teacherblitz.entity.TUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author teacherblitz
 * @version v1.0
 * @description
 * @date 2019/10/20 21:38
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    @RequestMapping("/test-get")
    public TUser getUser(TUser tUser){
        return tUser;
    }

}
