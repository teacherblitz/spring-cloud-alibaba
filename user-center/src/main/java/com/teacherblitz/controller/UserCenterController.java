package com.teacherblitz.controller;

import com.teacherblitz.entity.TUser;
import com.teacherblitz.service.ITUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author teacherblitz
 * @version v1.0
 * @description
 * @date 2019/9/23 23:19
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserCenterController {

    private final ITUserService itUserService;

    @RequestMapping("getUserInfo/{id}")
    public TUser getTUserInfo(@PathVariable("id") Integer id){
        return itUserService.selectTUserById(id);
    }

}

