package com.vw.consent.management.system.user.application.command;

public record UpdateConsentCommand(String email, String consentType, boolean enabled) {
}
