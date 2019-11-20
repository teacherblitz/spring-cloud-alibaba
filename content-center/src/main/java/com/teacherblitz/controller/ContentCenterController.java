package com.teacherblitz.controller;

import com.teacherblitz.entity.TUser;
import com.teacherblitz.service.ContentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author teacherblitz
 * @version v1.0
 * @description 内容中心Controller
 * @date 2019/10/19 15:07
 */
@Slf4j
@RestController("/share")
@RequiredArgsConstructor
public class ContentCenterController {

    private final ContentService contentService;

    @RequestMapping("/getContentInfo/{id}")
    public TUser getContentInfo(@PathVariable("id") Integer userId){
        TUser user = this.contentService.findById(userId);
        return user;
    }
}
