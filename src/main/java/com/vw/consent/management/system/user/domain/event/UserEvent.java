package com.vw.consent.management.system.user.domain.event;

import com.vw.consent.management.system.shared.domain.event.DomainEvent;
import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;
import com.vw.consent.management.system.shared.domain.valueobject.UserId;
import com.vw.consent.management.system.user.domain.entity.User;
import com.vw.consent.management.system.user.domain.valueobject.UserConsent;
import com.vw.consent.management.system.user.domain.valueobject.UserCreatedAt;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public abstract class UserEvent extends DomainEvent {
    private final UUID userId;
    private final String userEmail;
    private final Map<ConsentType, Boolean> userConsent;
    private final Instant userCreatedAt;


    protected UserEvent(String eventType, UUID userId, String userEmail, Map<ConsentType, Boolean> userConsent, Instant userCreatedAt) {
        super(eventType);
        this.userId = userId;
        this.userEmail = userEmail;
        this.userConsent = userConsent;
        this.userCreatedAt = userCreatedAt;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Map<ConsentType, Boolean> getUserConsent() {
        return userConsent;
    }

    public Instant getUserCreatedAt() {
        return userCreatedAt;
    }
}
