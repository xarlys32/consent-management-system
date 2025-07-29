package com.vw.consent.management.system.consent.application.command;

import java.time.Instant;

public record AddConsentAuditCommand(String userId, String consentType, boolean enabled, Instant createdAt) {

}
