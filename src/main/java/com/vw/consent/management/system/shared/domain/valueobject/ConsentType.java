package com.vw.consent.management.system.shared.domain.valueobject;

public enum ConsentType {
    EMAIL_NOTIFICATIONS, SMS_NOTIFICATIONS;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
