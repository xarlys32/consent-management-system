package com.vw.consent.management.system.user.application.port;

import com.vw.consent.management.system.user.application.query.GetUserByEmailResponse;
import com.vw.consent.management.system.user.domain.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> createUser(User user);
    User updateConsentUser(User user);
    Optional<GetUserByEmailResponse> findUserByEmail(String email);
}
