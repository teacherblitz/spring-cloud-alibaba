package com.teacherblitz.controller;

import com.teacherblitz.domain.dto.content.UserAuditDTO;
import com.teacherblitz.entity.TUser;
import com.teacherblitz.service.ShareService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author teacherblitz
 * @since 2019/11/14
 */
@Slf4j
@RestController
@RequestMapping("/admin/share")
@RequiredArgsConstructor
public class ContentCenterAdminController {

    private final ShareService shareService;

    @RequestMapping("/audit/{id}")
    public TUser auditById(@PathVariable Integer id, @RequestBody UserAuditDTO auditDto){
        return this.shareService.queryAuditById(id, auditDto);
    }
}
