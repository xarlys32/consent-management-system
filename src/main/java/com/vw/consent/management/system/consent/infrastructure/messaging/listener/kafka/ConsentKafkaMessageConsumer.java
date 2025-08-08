package com.vw.consent.management.system.consent.infrastructure.messaging.listener.kafka;

import com.vw.consent.management.system.consent.infrastructure.messaging.listener.kafka.config.KafkaConsumer;
import com.vw.consent.management.system.kafka_model.dto.ConsentChangeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ConsentKafkaMessageConsumer implements KafkaConsumer<ConsentChangeEvent> {

    @KafkaListener(topics = "user-consent-topic")
    public void receiveSingle(ConsentChangeEvent message) {
        log.info("Receive single event "+ message);
    }
}
