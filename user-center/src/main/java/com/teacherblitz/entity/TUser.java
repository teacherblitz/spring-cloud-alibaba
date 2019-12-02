package com.teacherblitz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-10-15
 */
@Data
@Builder
@Accessors(chain = true)
public class TUser {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Integer id;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 性别：1->男，2->女，0->未知
     */
    private Integer sex;

    /**
     * 审核状态
     */
    private String auditStatus;

    /**
     * 积分
     */
    private Integer Bonus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
