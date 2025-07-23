package com.vw.consent.management.system.user.domain.valueobject;

import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;

import java.util.HashMap;
import java.util.Map;

public class UserConsent {
    private final Map<ConsentType, Boolean> consent;

    public UserConsent(Map<ConsentType, Boolean> consents) {
        this.consent = Map.copyOf(consents);
    }

    public boolean isEnabled(ConsentType type) {
        return consent.getOrDefault(type, false);
    }

    public UserConsent updateConsent(ConsentType type, boolean enabled) {
        Map<ConsentType, Boolean> updated = new HashMap<>(consent);
        updated.put(type, enabled);
        return new UserConsent(updated);
    }

    public Map<ConsentType, Boolean> asMap() {
        return consent;
    }
}
