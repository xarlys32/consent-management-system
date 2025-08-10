package com.vw.consent.management.system.consent.infrastructure.messaging.listener.kafka.config;

import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.support.Acknowledgment;

import java.util.List;

public interface KafkaConsumer<T extends SpecificRecordBase> {
    void receiveSingle(T message, Acknowledgment ack);
}
