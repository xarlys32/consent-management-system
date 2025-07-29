package com.vw.consent.management.system.consent.application.handler;

import com.vw.consent.management.system.consent.application.command.AddConsentAuditCommand;
import com.vw.consent.management.system.consent.application.mapper.ConsentAuditApplicationMapper;
import com.vw.consent.management.system.consent.application.port.out.ConsentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddConsentAuditCommandHandler {
    private final ConsentAuditApplicationMapper consentAuditApplicationMapper;
    private final ConsentAuditRepository consentAuditRepository;


    public AddConsentAuditCommandHandler(ConsentAuditApplicationMapper consentAuditApplicationMapper, ConsentAuditRepository consentAuditRepository) {
        this.consentAuditApplicationMapper = consentAuditApplicationMapper;
        this.consentAuditRepository = consentAuditRepository;
    }

    @Transactional
    public void addConsentAudit(AddConsentAuditCommand addConsentAuditCommand) {
        var consentAudit = consentAuditApplicationMapper.addConsentAuditCommandToConsentAudit(addConsentAuditCommand);
        consentAuditRepository.save(consentAudit);
    }
}
