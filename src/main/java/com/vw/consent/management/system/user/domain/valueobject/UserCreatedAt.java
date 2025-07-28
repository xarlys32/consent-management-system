package com.vw.consent.management.system.user.domain.valueobject;

import java.time.Instant;

public class UserCreatedAt {
    private final Instant value;

    public UserCreatedAt(Instant value) {
        this.value = value;
    }

    public Instant getValue() {
        return value;
    }
}
