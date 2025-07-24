package com.vw.consent.management.system.user.application.command;

import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;

import java.util.Map;
import java.util.UUID;

public record CreateUserResponse(UUID id,
        String email, Map<ConsentType, Boolean> consent) {
}
