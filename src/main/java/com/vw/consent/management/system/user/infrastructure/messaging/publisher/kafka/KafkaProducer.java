package com.vw.consent.management.system.user.infrastructure.messaging.publisher.kafka;

import com.fever.plans_management_system.kafka_messaging_contracts.dto.BasePlan;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private final KafkaTemplate<String, BasePlan> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, BasePlan> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, BasePlan message) {
        kafkaTemplate.send(topic, message);
    }
}
