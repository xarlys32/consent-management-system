package com.vw.consent.management.system.consent.application.query;

import java.time.Instant;
import java.util.UUID;

public record GetConsentAuditHistoryResponse(UUID userId, String consentType, boolean enabled, Instant createdAt) {
}
