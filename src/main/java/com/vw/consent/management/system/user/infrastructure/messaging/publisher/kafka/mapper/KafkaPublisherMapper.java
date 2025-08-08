package com.vw.consent.management.system.user.infrastructure.messaging.publisher.kafka.mapper;

import com.vw.consent.management.system.kafka_model.dto.ConsentChangeEvent;
import com.vw.consent.management.system.kafka_model.dto.ConsentType;
import com.vw.consent.management.system.user.domain.event.UserEvent;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class KafkaPublisherMapper { // Refactor
    public <T extends UserEvent> ConsentChangeEvent userEventToConsentChangeEvent(T userEvent) {
        return new ConsentChangeEvent(userEvent.getUser().getId().getValue().toString(),
                userEvent.getUser().getUserEmail().getValue(),
                ConsentType.valueOf(userEvent.getUser().getUserConsent().asMap().keySet().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(""))),
                Boolean.valueOf(userEvent.getUser().getUserConsent().asMap().values().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(""))),
                userEvent.getOccurredOn());
    }
}
