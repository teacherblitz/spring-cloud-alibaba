package com.teacherblitz.domain.enums;

import lombok.Getter;

/**
 * 审核状态
 * @author teacherblitz
 * @since 2019/11/14
 */
@Getter
public enum AuditStatusEnum {
    /**
     * 待审核
     */
    NOT_YET,
    /**
     * 审核通过
     */
    PASS,
    /**
     * 审核驳回
     */
    REJECT
}
