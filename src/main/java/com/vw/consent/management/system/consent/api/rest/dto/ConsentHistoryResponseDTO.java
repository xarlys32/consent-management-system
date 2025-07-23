package com.vw.consent.management.system.consent.api.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ConsentHistoryResponseDTO {
    private String userId;
    private List<ConsentDTO> consents;
}
