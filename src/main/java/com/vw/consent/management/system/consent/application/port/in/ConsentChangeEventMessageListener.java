package com.vw.consent.management.system.consent.application.port.in;

import com.vw.consent.management.system.consent.domain.entity.ConsentChangeEvent;

public interface ConsentChangeEventMessageListener {
    void onConsentChangeEvent(ConsentChangeEvent event);
}
