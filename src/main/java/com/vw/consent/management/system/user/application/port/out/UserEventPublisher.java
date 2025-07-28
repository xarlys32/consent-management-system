package com.vw.consent.management.system.user.application.port.out;

import com.vw.consent.management.system.user.domain.event.UserEvent;

public interface UserEventPublisher {
    <T extends UserEvent> void publish(T event);
}
