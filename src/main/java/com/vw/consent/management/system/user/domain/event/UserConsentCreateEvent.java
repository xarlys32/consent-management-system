package com.vw.consent.management.system.user.domain.event;

import com.vw.consent.management.system.user.domain.entity.User;

import java.time.Instant;

public class UserConsentCreateEvent extends UserEvent {
    private final Instant createdAt;

    public UserConsentCreateEvent(User user, Instant createdAt) {
        super(user, "USER_CREATED");
        this.createdAt = createdAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
