package com.vw.consent.management.system.user.application.port.out;

import com.vw.consent.management.system.user.domain.entity.User;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;

import java.util.Optional;

public interface UserRepository {
    Optional<User> createUser(User user);
    User updateConsentUser(User user);
    Optional<User> findUserByEmail(UserEmail userEmail);
}
