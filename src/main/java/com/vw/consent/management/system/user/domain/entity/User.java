package com.vw.consent.management.system.user.domain.entity;

import com.vw.consent.management.system.shared.domain.entity.BaseEntity;
import com.vw.consent.management.system.shared.domain.valueobject.UserId;
import com.vw.consent.management.system.user.domain.event.UserConsentCreateEvent;
import com.vw.consent.management.system.user.domain.valueobject.UserConsent;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;

import java.time.Instant;

public class User extends BaseEntity<UserId> {
    private final UserEmail userEmail;
    private UserConsent userConsent;

    private User(Builder builder) {
        setId(builder.userId);
        userEmail = builder.userEmail;
        userConsent = builder.userConsent;
    }

    public UserEmail getUserEmail() {
        return userEmail;
    }

    public void setUserConsent(UserConsent userConsent) {
        this.userConsent = userConsent;
    }

    public UserConsent getUserConsent() {
        return userConsent;
    }

    public UserConsentCreateEvent userCreateEvent() {
        return new UserConsentCreateEvent(this, Instant.now());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UserId userId;
        private UserEmail userEmail;
        private UserConsent userConsent;

        private Builder() {
        }

        public Builder userId(UserId val) {
            userId = val;
            return this;
        }

        public Builder userEmail(UserEmail val) {
            userEmail = val;
            return this;
        }

        public Builder userConsent(UserConsent val) {
            userConsent = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
