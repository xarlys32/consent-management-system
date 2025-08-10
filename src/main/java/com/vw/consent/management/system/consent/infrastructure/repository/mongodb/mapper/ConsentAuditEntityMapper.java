package com.vw.consent.management.system.consent.infrastructure.repository.mongodb.mapper;

import com.vw.consent.management.system.consent.domain.entity.ConsentAudit;
import com.vw.consent.management.system.consent.infrastructure.repository.mongodb.entity.ConsentAuditEntity;
import org.springframework.stereotype.Component;

@Component
public class ConsentAuditEntityMapper {
    public ConsentAuditEntity consentAuditToEntity(ConsentAudit consentAudit) {
        return ConsentAuditEntity.builder()
                .userId(consentAudit.getUserId().getValue().toString())
                .consentType(consentAudit.getConsentType().getValue())
                .enabled(consentAudit.isEnabled())
                .eventTimestamp(consentAudit.getTimestamp())
                .build();
    }
}
