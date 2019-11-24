package com.teacherblitz.controller;

import com.teacherblitz.entity.TUser;
import com.teacherblitz.service.ITUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户中心Controller
 * @author teacherblitz
 * @since 2019/11/24
 */
@Slf4j
@RestController
@RequestMapping("/users/")
@RequiredArgsConstructor
public class UserCenterController {

    private final ITUserService itUserService;

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    @RequestMapping("getUserInfo/{id}")
    public TUser getTUserInfo(@PathVariable("id") Integer id){
        return itUserService.selectTUserById(id);
    }

}

