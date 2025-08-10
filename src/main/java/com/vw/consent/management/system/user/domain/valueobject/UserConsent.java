package com.vw.consent.management.system.user.domain.valueobject;

import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;

import java.util.HashMap;
import java.util.Map;

public class UserConsent {
    private final Map<ConsentType, Boolean> consent;

    public UserConsent(Map<ConsentType, Boolean> consents) {
        this.consent = Map.copyOf(consents);
    }

    public void updateConsent(ConsentType type, boolean enabled) {

    }

    public Map<ConsentType, Boolean> asMap() {
        return consent;
    }
}
