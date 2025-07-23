package com.vw.consent.management.system.consent.domain.valueobject;

import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;

import java.time.LocalDateTime;

public class ConsentStatus {
    private final ConsentEmail consentEmail;
    private final ConsentType type;
    private final boolean enabled;
    private final LocalDateTime occurredAt;


}
