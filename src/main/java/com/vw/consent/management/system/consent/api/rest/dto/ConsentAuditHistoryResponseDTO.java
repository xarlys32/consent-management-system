package com.vw.consent.management.system.consent.api.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;


public record ConsentAuditHistoryResponseDTO (UUID userId,
        String email,
        List<ConsentDTO> consents){

}
