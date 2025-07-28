package com.vw.consent.management.system.user.domain.event;

import com.vw.consent.management.system.user.domain.entity.User;

import java.time.Instant;

public class UserConsentCreateEvent extends UserEvent {

    public UserConsentCreateEvent(User user) {
        super(user, "USER_CREATED");
    }

}
