package com.vw.consent.management.system.user.application.query.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class UserGetView {
    private UUID id;
    private String email;
    private Map<String, Boolean> consents;
    private Instant createdAt;
}
