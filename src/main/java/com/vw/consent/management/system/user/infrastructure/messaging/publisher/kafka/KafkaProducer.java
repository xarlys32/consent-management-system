package com.vw.consent.management.system.user.infrastructure.messaging.publisher.kafka;

import com.vw.consent.management.system.kafka_model.dto.ConsentChangeEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private final KafkaTemplate<String, ConsentChangeEvent> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, ConsentChangeEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, ConsentChangeEvent message) {
        kafkaTemplate.send(topic, message);
    }
}
