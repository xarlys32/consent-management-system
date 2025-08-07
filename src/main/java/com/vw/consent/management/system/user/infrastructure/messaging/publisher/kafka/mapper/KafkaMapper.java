package com.vw.consent.management.system.user.infrastructure.messaging.publisher.kafka.mapper;

import com.vw.consent.management.system.kafka_model.dto.ConsentChangeEvent;
import com.vw.consent.management.system.user.domain.event.UserEvent;

import java.util.Map;
import java.util.stream.Collectors;

public class KafkaMapper {
    public <T extends UserEvent> ConsentChangeEvent userEventToConsentChangeEvent(T userEvent) {
        return new ConsentChangeEvent(userEvent.getUser().getId().getValue(),
                userEvent.getUser().getUserEmail().getValue(),
                userEvent.getUser().getUserConsent().asMap().keySet().
    }
}
