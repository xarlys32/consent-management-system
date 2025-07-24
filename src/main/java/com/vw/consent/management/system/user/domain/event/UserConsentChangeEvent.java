package com.vw.consent.management.system.user.domain.event;

import com.vw.consent.management.system.user.domain.entity.User;

import java.time.Instant;

public class UserConsentChangeEvent extends UserEvent {

    protected UserConsentChangeEvent(User user) {
        super(user, "USER_CHANGE");
    }
}
