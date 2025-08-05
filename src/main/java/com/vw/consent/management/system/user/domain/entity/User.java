package com.vw.consent.management.system.user.domain.entity;

import com.vw.consent.management.system.shared.domain.entity.BaseEntity;
import com.vw.consent.management.system.shared.domain.valueobject.UserId;
import com.vw.consent.management.system.user.domain.event.UserConsentCreateEvent;
import com.vw.consent.management.system.user.domain.event.UserConsentUpdateEvent;
import com.vw.consent.management.system.user.domain.valueobject.UserConsent;
import com.vw.consent.management.system.user.domain.valueobject.UserCreatedAt;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;

import java.time.Instant;

public class User extends BaseEntity<UserId> {
    private final UserEmail userEmail;
    private UserConsent userConsent;
    private UserCreatedAt userCreatedAt;

    private User(Builder builder) {
        setId(builder.userId);
        userEmail = builder.userEmail;
        userConsent = builder.userConsent;
        userCreatedAt = builder.userCreatedAt;
    }

    public UserEmail getUserEmail() {
        return userEmail;
    }

    public UserConsent getUserConsent() {
        return userConsent;
    }

    public UserCreatedAt getUserCreatedAt() {
        return userCreatedAt;
    }

    public UserConsentCreateEvent createUser() {
        userCreatedAt = new UserCreatedAt(Instant.now());
        return new UserConsentCreateEvent(this);
    }

    public UserConsentUpdateEvent updateUserConsent(UserConsent userConsent) {
        this.userConsent = userConsent;
        return new UserConsentUpdateEvent(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UserId userId;
        private UserEmail userEmail;
        private UserConsent userConsent;
        private UserCreatedAt userCreatedAt;

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

        public Builder userCreatedAt(UserCreatedAt val) {
            userCreatedAt = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
