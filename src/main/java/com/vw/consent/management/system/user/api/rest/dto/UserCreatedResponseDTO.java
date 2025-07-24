package com.vw.consent.management.system.user.api.rest.dto;


import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;
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
    private Map<ConsentType, Boolean> consent;
}
