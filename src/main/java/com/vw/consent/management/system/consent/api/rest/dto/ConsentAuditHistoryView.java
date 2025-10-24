package com.vw.consent.management.system.consent.api.rest.dto;

import java.util.List;
import java.util.UUID;


public record ConsentAuditHistoryView(UUID userId,
                                      String email,
                                      List<ConsentView> consents){

}
