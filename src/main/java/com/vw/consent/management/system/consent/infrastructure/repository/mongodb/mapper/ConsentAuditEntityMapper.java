package com.vw.consent.management.system.consent.infrastructure.repository.mongodb.mapper;

import com.vw.consent.management.system.consent.domain.entity.ConsentAudit;
import com.vw.consent.management.system.consent.infrastructure.repository.mongodb.entity.ConsentAuditEntity;
import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;
import com.vw.consent.management.system.shared.domain.valueobject.UserId;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;

@Component
public class ConsentAuditEntityMapper {
    public ConsentAuditEntity consentAuditToEntity(ConsentAudit consentAudit) {
        return ConsentAuditEntity.builder()
                .userId(consentAudit.getUserId().getValue())
                .email(consentAudit.getUserEmail().getValue())
                .consentType(consentAudit.getConsentType().getValue())
                .enabled(consentAudit.isEnabled())
                .eventTimestamp(consentAudit.getTimestamp())
                .build();
    }

    public ConsentAudit consentAuditEntityToDom(ConsentAuditEntity entity) {
        return ConsentAudit.builder()
                .userId(new UserId(entity.getUserId()))
                .userEmail(new UserEmail(entity.getEmail()))
                .consentType(ConsentType.fromValue(entity.getConsentType()).orElseThrow(() -> new InvalidParameterException("Error type")))
                .enabled(entity.isEnabled())
                .timestamp(entity.getEventTimestamp())
                .build();
    }
}
