package com.vw.consent.management.system.shared.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

public class UserId extends BaseId<UUID> {

    protected UserId(UUID value) {
        super(value);
    }
}
