package com.vw.consent.management.system.user.application.command;

import jakarta.validation.constraints.NotBlank;

public record CreateUserCommand(@NotBlank String email, String consentType, boolean enabled) {
}

