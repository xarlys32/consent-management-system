package com.vw.consent.management.system.consent.infrastructure.repostory.mongodb;

import com.vw.consent.management.system.consent.application.port.out.ConsentAuditRepository;
import com.vw.consent.management.system.consent.domain.entity.ConsentAudit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsentAuditRepositoryImpl implements ConsentAuditRepository {
    @Override
    public Optional<ConsentAudit> save(ConsentAudit consentAudit) {
        return Optional.empty();
    }

    @Override
    public List<ConsentAudit> getConsentAuditsByUserId(UUID userId) {
        return List.of();
    }
}
