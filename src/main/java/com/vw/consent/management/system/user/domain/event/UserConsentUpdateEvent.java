package com.vw.consent.management.system.user.domain.event;

import com.vw.consent.management.system.user.domain.entity.User;

import java.time.Instant;

public class UserConsentUpdateEvent extends UserEvent {

    public UserConsentUpdateEvent(User user) {
        super(user, "USER_CHANGE");
    }
}
