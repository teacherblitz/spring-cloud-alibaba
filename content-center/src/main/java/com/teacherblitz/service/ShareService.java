package com.teacherblitz.service;

import com.teacherblitz.domain.dto.content.UserAuditDTO;
import com.teacherblitz.entity.TUser;

/**
 * @author teacherblitz
 * @since 2019/11/14
 */
public interface ShareService {

    TUser queryAuditById(Integer id, UserAuditDTO auditDto);
}
