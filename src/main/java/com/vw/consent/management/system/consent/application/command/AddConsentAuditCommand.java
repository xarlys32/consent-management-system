package com.vw.consent.management.system.consent.application.command;

import java.time.Instant;
import java.util.UUID;

public record AddConsentAuditCommand(UUID userId, String consentType, boolean enabled, Instant createdAt) {

}
