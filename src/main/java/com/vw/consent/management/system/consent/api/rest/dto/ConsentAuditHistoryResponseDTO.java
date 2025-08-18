package com.vw.consent.management.system.consent.api.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ConsentAuditHistoryResponseDTO {
    private UUID userId;
    private String email;
    private List<ConsentDTO> consents;
}
