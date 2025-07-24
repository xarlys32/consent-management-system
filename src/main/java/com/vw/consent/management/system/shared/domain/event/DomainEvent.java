package com.vw.consent.management.system.shared.domain.event;

import java.time.Instant;
import java.util.UUID;

public abstract class DomainEvent {
    private final String eventType;     // e.g., "consent.changed"
    private final Instant occurredOn;   // cuándo ocurrió el evento
    private final UUID eventId;         // identificador único del evento

    protected DomainEvent(String eventType) {
        this.eventType = eventType;
        this.occurredOn = Instant.now();
        this.eventId = UUID.randomUUID();
    }

    public String getEventType() {
        return eventType;
    }

    public Instant getOccurredOn() {
        return occurredOn;
    }

    public UUID getEventId() {
        return eventId;
    }
}
