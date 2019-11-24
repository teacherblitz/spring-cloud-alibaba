package com.teacherblitz.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teacherblitz.domain.dto.messaging.UserAddBonusMsgDTO;
import com.teacherblitz.entity.TUser;
import com.teacherblitz.mapper.TUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-10-15
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

    private final TUserMapper tUserMapper;

    @Override
    public TUser selectTUserById(Integer id) {
        return tUserMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addBonus(UserAddBonusMsgDTO msgDTO) {
        Integer userId = msgDTO.getUserId();
        Integer bonus = msgDTO.getBonus();
        TUser user = tUserMapper.selectById(userId);
        user.setBonus(user.getBonus() + bonus);
        // 添加积分
        tUserMapper.updateById(user);
    }
}
