package com.vw.consent.management.system.user.application.query;

import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public record GetUserByEmailResponse(UUID id,
                                     String email, Map<ConsentType, Boolean> consent,
                                     Instant createdAt) {
}
