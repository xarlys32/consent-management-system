package com.vw.consent.management.system.consent.api.rest.mapper;

import com.vw.consent.management.system.consent.api.rest.dto.ConsentAuditHistoryView;
import com.vw.consent.management.system.consent.api.rest.dto.ConsentView;
import com.vw.consent.management.system.consent.application.query.GetConsentAuditHistoryResponse;
import com.vw.consent.management.system.consent.domain.exceptions.UserIdNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsentAuditDTOMapper {

    public ConsentAuditHistoryView listOfGetConsentAuditHistoryResponseToResponseDTO(
            List<GetConsentAuditHistoryResponse> consentAuditHistoryResponseList) {
        return new ConsentAuditHistoryView(
                consentAuditHistoryResponseList.stream().findFirst().orElseThrow(UserIdNotFoundException::new).userId(),
                consentAuditHistoryResponseList.stream().findFirst().orElseThrow(UserIdNotFoundException::new).email(),
                consentAuditHistoryResponseList.stream().map(consentAudit ->
                        new ConsentView(
                                consentAudit.consentType(),
                                consentAudit.enabled(),
                                consentAudit.createdAt()))
                        .toList()
        );
    }
}
