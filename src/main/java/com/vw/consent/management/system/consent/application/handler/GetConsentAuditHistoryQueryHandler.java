package com.vw.consent.management.system.consent.application.handler;


import com.vw.consent.management.system.consent.application.mapper.ConsentAuditApplicationMapper;
import com.vw.consent.management.system.consent.application.port.out.ConsentAuditRepository;
import com.vw.consent.management.system.consent.application.query.GetConsentAuditHistoryQuery;
import com.vw.consent.management.system.consent.application.query.GetConsentAuditHistoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetConsentAuditHistoryQueryHandler  {
    private final ConsentAuditApplicationMapper consentAuditApplicationMapper;
    private final ConsentAuditRepository consentAuditRepository;

    public GetConsentAuditHistoryQueryHandler(ConsentAuditApplicationMapper consentAuditApplicationMapper, ConsentAuditRepository consentAuditRepository) {
        this.consentAuditApplicationMapper = consentAuditApplicationMapper;
        this.consentAuditRepository = consentAuditRepository;
    }

    public List<GetConsentAuditHistoryResponse> getConsentAuditHistory(GetConsentAuditHistoryQuery getConsentAuditHistoryQuery) {
        return consentAuditRepository.getConsentAuditsByUserId(getConsentAuditHistoryQuery.userId())
                .stream()
                .map(consentAuditApplicationMapper::consentAuditToGetConsentAuditHistoryResponse)
                .toList();
    }
}
