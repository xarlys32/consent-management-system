package com.vw.consent.management.system.consent.infrastructure.messaging.listener.kafka;

import com.vw.consent.management.system.consent.application.command.AddConsentAuditCommand;
import com.vw.consent.management.system.consent.application.handler.AddConsentAuditCommandHandler;
import com.vw.consent.management.system.consent.infrastructure.messaging.listener.kafka.config.KafkaConsumer;
import com.vw.consent.management.system.common.infrastructure.kafka_model.dto.ConsentChangeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class ConsentKafkaMessageConsumer implements KafkaConsumer<ConsentChangeEvent> {

    private final AddConsentAuditCommandHandler addConsentAuditCommandHandler;

    public ConsentKafkaMessageConsumer(AddConsentAuditCommandHandler addConsentAuditCommandHandler) {
        this.addConsentAuditCommandHandler = addConsentAuditCommandHandler;
    }

    @KafkaListener(topics = "user-consent-topic", groupId = "user-consent-event")
    public void receiveSingle(ConsentChangeEvent message, Acknowledgment ack) {
        log.info("Receive single event "+ message);
        addConsentAuditCommandHandler.addConsentAudit(new AddConsentAuditCommand(
                UUID.fromString(message.getUserId().toString()),
                message.getEmail().toString(),
                message.getConsentType().name(),
                message.getEnabled(),
                message.getEventTimestamp()));
        ack.acknowledge();
    }
}
