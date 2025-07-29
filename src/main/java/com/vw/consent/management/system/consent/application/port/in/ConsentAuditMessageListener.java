package com.vw.consent.management.system.consent.application.port.in;

import com.vw.consent.management.system.consent.domain.entity.ConsentAudit;

public interface ConsentAuditMessageListener {
    void onConsentChangeEvent(ConsentAudit event);
}
