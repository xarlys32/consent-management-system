package com.vw.consent.management.system.consent.infrastructure.repository;

import com.vw.consent.management.system.consent.application.port.out.ConsentAuditRepository;
import com.vw.consent.management.system.consent.domain.entity.ConsentAudit;
import com.vw.consent.management.system.consent.infrastructure.repository.mongodb.ConsentAuditMongoRepository;
import com.vw.consent.management.system.consent.infrastructure.repository.mongodb.mapper.ConsentAuditEntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsentAuditRepositoryImpl implements ConsentAuditRepository {

    private final ConsentAuditMongoRepository consentAuditMongoRepository;
    private final ConsentAuditEntityMapper consentAuditEntityMapper;

    public ConsentAuditRepositoryImpl(ConsentAuditMongoRepository consentAuditMongoRepository, ConsentAuditEntityMapper consentAuditEntityMapper) {
        this.consentAuditMongoRepository = consentAuditMongoRepository;
        this.consentAuditEntityMapper = consentAuditEntityMapper;
    }

    @Override
    public Optional<ConsentAudit> save(ConsentAudit consentAudit) {
        consentAuditMongoRepository.save(consentAuditEntityMapper.consentAuditToEntity(consentAudit));
        return Optional.empty();
    }

    @Override
    public List<ConsentAudit> getConsentAuditsByUserId(UUID userId) {
        return List.of();
    }
}
