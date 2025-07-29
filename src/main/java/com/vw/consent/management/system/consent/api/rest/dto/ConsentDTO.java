package com.vw.consent.management.system.consent.api.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ConsentDTO {
    private String consentType;
    private boolean enabled;
    private Instant updateTimestamp;
}
