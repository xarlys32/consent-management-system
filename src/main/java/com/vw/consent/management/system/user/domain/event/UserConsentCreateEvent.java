package com.vw.consent.management.system.user.domain.event;

import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;
import com.vw.consent.management.system.user.domain.entity.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public class UserConsentCreateEvent extends UserEvent {

    public UserConsentCreateEvent(UUID userId, String userEmail, Map<ConsentType, Boolean> userConsent, Instant userCreatedAt) {
        super("USER_CREATED", userId, userEmail, userConsent, userCreatedAt);
    }

}
