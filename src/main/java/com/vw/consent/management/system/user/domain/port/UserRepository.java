package com.vw.consent.management.system.user.domain.port;

import com.vw.consent.management.system.user.domain.entity.User;

public interface UserRepository {
    User createUser(User user);
    User updateConsentUser(User user);
}
