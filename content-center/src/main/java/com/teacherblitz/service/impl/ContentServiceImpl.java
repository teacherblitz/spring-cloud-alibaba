package com.teacherblitz.service.impl;

import com.teacherblitz.entity.TUser;
import com.teacherblitz.feignclient.UserCenterFeignClient;
import com.teacherblitz.service.ContentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author teacherblitz
 * @since 2019/11/13
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {

    private final UserCenterFeignClient userCenterFeignClient;

    @Override
    public TUser findById(Integer userId) {
        return this.userCenterFeignClient.findById(userId);
    }
}
