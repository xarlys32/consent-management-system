package com.vw.consent.management.system.user.api.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;
@Getter
@Builder
@AllArgsConstructor
public class UserCreatedResponseDTO {
    private UUID id;
    private String email;
    private Map<String, Boolean> consent;
}
