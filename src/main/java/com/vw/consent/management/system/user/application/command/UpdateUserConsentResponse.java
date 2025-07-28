package com.vw.consent.management.system.user.application.command;

import java.util.Map;
import java.util.UUID;

public record UpdateUserConsentResponse(UUID id,
                                        String email, Map<String, Boolean> consent) {
}
