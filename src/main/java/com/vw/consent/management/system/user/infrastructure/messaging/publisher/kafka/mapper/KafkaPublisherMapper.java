package com.vw.consent.management.system.user.infrastructure.messaging.publisher.kafka.mapper;

import com.vw.consent.management.system.common.infrastructure.kafka_model.dto.ConsentChangeEvent;
import com.vw.consent.management.system.common.infrastructure.kafka_model.dto.ConsentType;
import com.vw.consent.management.system.user.domain.event.UserEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KafkaPublisherMapper { // Refactor
    public <T extends UserEvent> ConsentChangeEvent userEventToConsentChangeEvent(T userEvent) {
        Map<com.vw.consent.management.system.shared.domain.valueobject.ConsentType, Boolean> consents = userEvent.getUserConsent();

        com.vw.consent.management.system.shared.domain.valueobject.ConsentType domainConsentType = null;
        boolean enabled = false;

        if (consents != null && !consents.isEmpty()) {
            // Prefer an entry that is enabled (true)
            for (Map.Entry<com.vw.consent.management.system.shared.domain.valueobject.ConsentType, Boolean> entry : consents.entrySet()) {
                if (Boolean.TRUE.equals(entry.getValue())) {
                    domainConsentType = entry.getKey();
                    enabled = true;
                    break;
                }
            }

            // Fallback: take the first entry
            if (domainConsentType == null) {
                Map.Entry<com.vw.consent.management.system.shared.domain.valueobject.ConsentType, Boolean> first = consents.entrySet().iterator().next();
                domainConsentType = first.getKey();
                enabled = Boolean.TRUE.equals(first.getValue());
            }
        } else {
            // Default if no consent info: map to EMAIL_NOTIFICATIONS disabled (safe default)
            domainConsentType = com.vw.consent.management.system.shared.domain.valueobject.ConsentType.EMAIL_NOTIFICATIONS;
        }

        // Map domain enum name to Avro enum (names are the same: EMAIL_NOTIFICATIONS / SMS_NOTIFICATIONS)
        ConsentType avroConsentType = ConsentType.valueOf(domainConsentType.name());

        return new ConsentChangeEvent(userEvent.getUserId().toString(),
                userEvent.getUserEmail(),
                avroConsentType,
                enabled,
                userEvent.getOccurredOn());
    }
}
