package com.vw.consent.management.system.user.infrastructure.messaging.publisher;

import com.vw.consent.management.system.user.application.port.out.UserEventPublisher;
import com.vw.consent.management.system.user.domain.event.UserEvent;
import com.vw.consent.management.system.user.infrastructure.messaging.publisher.kafka.KafkaProducer;
import com.vw.consent.management.system.user.infrastructure.messaging.publisher.kafka.mapper.KafkaPublisherMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserEventPublisherImpl implements UserEventPublisher {
    private final KafkaProducer kafkaProducer;
    private final KafkaPublisherMapper kafkaPublisherMapper;
    private final static String TOPIC = "user-consent-topic";

    public UserEventPublisherImpl(KafkaProducer kafkaProducer, KafkaPublisherMapper kafkaPublisherMapper) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaPublisherMapper = kafkaPublisherMapper;
    }

    @Override
    public <T extends UserEvent> void publish(T event) {
        log.info("Sending event {}", event);
        kafkaProducer.send(TOPIC, kafkaPublisherMapper.userEventToConsentChangeEvent(event));
    }
}
