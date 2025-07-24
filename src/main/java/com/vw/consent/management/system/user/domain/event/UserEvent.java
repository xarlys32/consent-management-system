package com.vw.consent.management.system.user.domain.event;

import com.vw.consent.management.system.shared.domain.event.DomainEvent;
import com.vw.consent.management.system.user.domain.entity.User;

public abstract class UserEvent extends DomainEvent {
    private final User user;

    protected UserEvent(User user, String eventType) {
        super(eventType);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
