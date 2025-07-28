package com.vw.consent.management.system.user.application.command;

public record UpdateUserConsentCommand(String email, String consentType, boolean enabled) {
}
