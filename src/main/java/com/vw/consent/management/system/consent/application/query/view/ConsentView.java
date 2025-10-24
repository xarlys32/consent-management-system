package com.vw.consent.management.system.consent.application.query.view;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ConsentView {
    private String consentType;
    private boolean enabled;
    private Instant updateTimestamp;
}
