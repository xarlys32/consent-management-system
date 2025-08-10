package com.vw.consent.management.system.consent.infrastructure.repository.mongodb.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "consent_audit")
public class ConsentAuditEntity {
    @Id
    private String userId;
    @Field(name = "email")
    private String email;
    @Field(name = "consentType")
    private String consentType;
    @Field(name = "enabled")
    private boolean enabled;
    @Field(name = "eventTimestamp")
    private Instant eventTimestamp;
}
