package com.vw.consent.management.system.user.application.command;

public record CreateUserCommand(String email, String consentType, boolean enabled) {
}

