package com.teacherblitz.entity.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author teacherblitz
 * @version v1.0
 * @description
 * @date 2019/10/15 20:46
 */
@Data
public class BaseEntity {

    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private Integer id;
}
