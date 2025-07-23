package com.vw.consent.management.system.user.application.query;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public record GetUserByEmailResponse(UUID id,
                                     String email, Map<String, Boolean> consent,
                                     Instant createdAt) {
}
