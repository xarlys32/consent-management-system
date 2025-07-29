package com.vw.consent.management.system.consent.domain.entity;

import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;
import com.vw.consent.management.system.shared.domain.valueobject.UserId;

import java.time.Instant;

public class ConsentAudit {
    private final UserId userId;
    private final ConsentType consentType;
    private final boolean enabled;
    private final Instant timestamp;

    private ConsentAudit(Builder builder) {
        userId = builder.userId;
        consentType = builder.consentType;
        enabled = builder.enabled;
        timestamp = builder.timestamp;
    }

    public UserId getUserId() {
        return userId;
    }

    public ConsentType getConsentType() {
        return consentType;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Instant getTimestamp() {
        return timestamp;
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UserId userId;
        private ConsentType consentType;
        private boolean enabled;
        private Instant timestamp;

        private Builder() {
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder consentType(ConsentType val) {
            consentType = val;
            return this;
        }

        public Builder enabled(boolean val) {
            enabled = val;
            return this;
        }

        public Builder timestamp(Instant val) {
            timestamp = val;
            return this;
        }

        public ConsentAudit build() {
            return new ConsentAudit(this);
        }
    }
}
