package com.vw.consent.management.system.user.infrastructure.messaging.publisher.kafka;

import com.vw.consent.management.system.user.application.port.out.UserEventPublisher;
import com.vw.consent.management.system.user.domain.event.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserEventPublisherImpl implements UserEventPublisher {
    @Override
    public <T extends UserEvent> void publish(T event) {
        log.info("Sending event {}", event);
    }
}
