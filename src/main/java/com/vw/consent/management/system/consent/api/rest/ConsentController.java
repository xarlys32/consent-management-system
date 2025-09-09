package com.vw.consent.management.system.consent.api.rest;

import com.vw.consent.management.system.consent.api.rest.dto.ConsentAuditHistoryResponseDTO;
import com.vw.consent.management.system.consent.api.rest.mapper.ConsentAuditDTOMapper;
import com.vw.consent.management.system.consent.application.handler.GetConsentAuditHistoryQueryHandler;
import com.vw.consent.management.system.consent.application.query.GetConsentAuditHistoryQuery;
import com.vw.consent.management.system.consent.application.query.GetConsentAuditHistoryResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController("/consents-audit")
public class ConsentController {

    private final GetConsentAuditHistoryQueryHandler getConsentAuditHistoryQueryHandler;
    private final ConsentAuditDTOMapper consentAuditDTOMapper;

    public ConsentController(GetConsentAuditHistoryQueryHandler getConsentAuditHistoryQueryHandler,
                             ConsentAuditDTOMapper consentAuditDTOMapper) {
        this.getConsentAuditHistoryQueryHandler = getConsentAuditHistoryQueryHandler;
        this.consentAuditDTOMapper = consentAuditDTOMapper;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ConsentAuditHistoryResponseDTO> getConsentAuditByUserId(@PathVariable String userId) {
        List<GetConsentAuditHistoryResponse> responseList = getConsentAuditHistoryQueryHandler.getConsentAuditHistory(
                new GetConsentAuditHistoryQuery(UUID.fromString(userId)));

        ConsentAuditHistoryResponseDTO responseDTO = consentAuditDTOMapper.
                listOfGetConsentAuditHistoryResponseToResponseDTO(responseList);

        return ResponseEntity.ok(responseDTO);
    }


}
