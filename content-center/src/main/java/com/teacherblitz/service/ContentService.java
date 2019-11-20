package com.teacherblitz.service;

import com.teacherblitz.entity.TUser;

/**
 * @author zhuyuan
 * @since 2019/11/13
 */
public interface ContentService {

    /**
     * 根据ID获取用户
     * @param userId
     * @return
     */
    TUser findById(Integer userId);
}
