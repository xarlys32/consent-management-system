package com.vw.consent.management.system.consent.application.command;

public record AddConsentHistory(String userId, String consentType, boolean enabled) {
}
