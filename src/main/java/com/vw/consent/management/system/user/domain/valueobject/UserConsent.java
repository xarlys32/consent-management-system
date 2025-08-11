package com.vw.consent.management.system.user.domain.valueobject;

import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;

import java.util.HashMap;
import java.util.Map;

public class UserConsent {
    private final Map<ConsentType, Boolean> consent;

    public UserConsent(Map<ConsentType, Boolean> consents) {
        this.consent = consents;
    }

    public void updateConsent(Map<ConsentType, Boolean> consentsUpdated) {
        boolean someNewEnabled = consentsUpdated.containsValue(true);

        if (someNewEnabled) {
            consent.replaceAll((key, value) -> false);

            consentsUpdated.forEach((key, value) -> {
                if (Boolean.TRUE.equals(value)) {
                    consent.put(key, true);
                }
            });
        } else {
            consent.putAll(consentsUpdated);
        }
    }

    public Map<ConsentType, Boolean> asMap() {
        return consent;
    }
}
