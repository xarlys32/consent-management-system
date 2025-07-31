package com.vw.consent.management.system.consent.api.rest.mapper;

import com.vw.consent.management.system.consent.api.rest.dto.ConsentAuditHistoryResponseDTO;
import com.vw.consent.management.system.consent.api.rest.dto.ConsentDTO;
import com.vw.consent.management.system.consent.application.query.GetConsentAuditHistoryResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsentAuditDTOMapper {

    public ConsentAuditHistoryResponseDTO listOfGetConsentAuditHistoryResponseToResponseDTO(
            List<GetConsentAuditHistoryResponse> consentAuditHistoryResponseList) {
        return new ConsentAuditHistoryResponseDTO(
                consentAuditHistoryResponseList.stream().findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid argument consentAuditHistoryResponseList")).userId(),
                consentAuditHistoryResponseList.stream().map(consentAudit ->
                        new ConsentDTO(
                                consentAudit.consentType(),
                                consentAudit.enabled(),
                                consentAudit.createdAt()))
                        .toList()
        );
    }
}
