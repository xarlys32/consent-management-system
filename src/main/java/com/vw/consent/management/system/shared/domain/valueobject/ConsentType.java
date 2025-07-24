package com.vw.consent.management.system.shared.domain.valueobject;

import java.util.Arrays;
import java.util.Optional;

public enum ConsentType {
    EMAIL_NOTIFICATIONS("email_notifications"),
    SMS_NOTIFICATIONS("sms_notifications");

    private final String value;

    ConsentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Optional<ConsentType> fromValue(String value) {
        return Arrays.stream(ConsentType.values())
                .filter(c -> c.value.equalsIgnoreCase(value))
                .findFirst();
    }
}
