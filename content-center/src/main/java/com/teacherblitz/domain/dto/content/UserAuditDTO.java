package com.teacherblitz.domain.dto.content;

import com.teacherblitz.domain.enums.AuditStatusEnum;
import lombok.Data;

/**
 * @author teacherblitz
 * @since 2019/11/14
 */
@Data
public class UserAuditDTO {
    /**
     * 审核状态
     */
    private AuditStatusEnum auditStatusEnum;
    /**
     * 原因
     */
    private String reason;
}
