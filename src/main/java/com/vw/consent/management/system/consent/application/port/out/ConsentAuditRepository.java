package com.vw.consent.management.system.consent.application.port.out;

import com.vw.consent.management.system.consent.domain.entity.ConsentAudit;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ConsentAuditRepository {
    Optional<ConsentAudit> save(ConsentAudit consentAudit);
    List<ConsentAudit> getConsentAuditsByUserId(UUID userId);
}
