package com.teacherblitz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.teacherblitz.entity.TUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-10-15
 */
public interface ITUserService extends IService<TUser> {

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    TUser selectTUserById(Integer id);

}
