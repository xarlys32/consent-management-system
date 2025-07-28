package com.vw.consent.management.system.consent.application.command;

public record AddConsentAudit(String userId, String consentType, boolean enabled) {
}
