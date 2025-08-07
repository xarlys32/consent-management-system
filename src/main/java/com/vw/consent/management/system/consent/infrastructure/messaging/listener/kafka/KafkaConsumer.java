package com.vw.consent.management.system.consent.infrastructure.messaging.listener.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "user-consent-topic", groupId = "user-consent-event")
    public void listener(Object basePlan) {

    }
}
