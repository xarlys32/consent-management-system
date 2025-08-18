package com.vw.consent.management.system.consent.application.mapper;

import com.vw.consent.management.system.consent.application.command.AddConsentAuditCommand;
import com.vw.consent.management.system.consent.application.query.GetConsentAuditHistoryResponse;
import com.vw.consent.management.system.consent.domain.entity.ConsentAudit;
import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;
import com.vw.consent.management.system.shared.domain.valueobject.UserId;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;
import org.springframework.stereotype.Component;

@Component
public class ConsentAuditApplicationMapper {
    public ConsentAudit addConsentAuditCommandToConsentAudit(AddConsentAuditCommand addConsentAuditCommand) {
        return ConsentAudit.builder()
                .userId(new UserId(addConsentAuditCommand.userId()))
                .userEmail(new UserEmail(addConsentAuditCommand.email()))
                .consentType(ConsentType.fromValue(addConsentAuditCommand.consentType()).orElseThrow(()-> new IllegalArgumentException("")))
                .enabled(addConsentAuditCommand.enabled())
                .timestamp(addConsentAuditCommand.createdAt())
                .build();
    }

    public GetConsentAuditHistoryResponse consentAuditToGetConsentAuditHistoryResponse(ConsentAudit consentAudit) {
        return new GetConsentAuditHistoryResponse(
                consentAudit.getUserId().getValue(),
                consentAudit.getUserEmail().getValue(),
                consentAudit.getConsentType().name(),
                consentAudit.isEnabled(),
                consentAudit.getTimestamp()
        );
    }
}
