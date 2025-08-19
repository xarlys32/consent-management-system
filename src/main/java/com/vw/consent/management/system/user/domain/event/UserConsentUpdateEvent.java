package com.vw.consent.management.system.user.domain.event;

import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;
import com.vw.consent.management.system.user.domain.entity.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class UserConsentUpdateEvent extends UserEvent {

    public UserConsentUpdateEvent(UUID userId, String userEmail, Map<ConsentType, Boolean> userConsent, Instant userCreatedAt) {
        super("USER_CHANGE", userId, userEmail, userConsent, userCreatedAt);
    }
}
