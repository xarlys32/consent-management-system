package com.vw.consent.management.system.consent.infrastructure.messaging.listener.kafka;

import com.fever.plans_management_system.kafka_messaging_contracts.dto.BasePlan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "user-consent-topic", groupId = "user-consent-event")
    public void listener(BasePlan basePlan) {

    }
}
