package com.vw.consent.management.system.consent.infrastructure.messaging.listener.kafka;

import com.vw.consent.management.system.consent.infrastructure.messaging.listener.kafka.config.KafkaConsumer;
import com.vw.consent.management.system.kafka_model.dto.ConsentChangeEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsentKafkaMessageConsumer implements KafkaConsumer<ConsentChangeEvent> {

    @KafkaListener(topics = "user-consent-topic", groupId = "user-consent-event")
    public void receive(List<ConsentChangeEvent> messages, List<String> keys, List<Integer> partitions, List<Long> offsets) {

    }
}
