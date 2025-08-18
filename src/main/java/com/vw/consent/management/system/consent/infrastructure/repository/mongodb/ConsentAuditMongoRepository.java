package com.vw.consent.management.system.consent.infrastructure.repository.mongodb;

import com.vw.consent.management.system.consent.infrastructure.repository.mongodb.entity.ConsentAuditEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ConsentAuditMongoRepository extends MongoRepository<ConsentAuditEntity, UUID> {
    List<ConsentAuditEntity> findByUserId(UUID userId);
}
