package com.vw.consent.management.system.user.application.command;

import java.util.Map;
import java.util.UUID;

public record CreateUserResponse(UUID id,
        String email, Map<String, Boolean> consent) {
}
