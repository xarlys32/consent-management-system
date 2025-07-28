package com.vw.consent.management.system.user.infrastructure.repository;
import com.vw.consent.management.system.user.application.query.GetUserByEmailResponse;
import com.vw.consent.management.system.user.domain.entity.User;
import com.vw.consent.management.system.user.application.port.out.UserRepository;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<User> createUser(User user) {
        return null;
    }

    @Override
    public User updateConsentUser(User user) {
        return null;
    }

    @Override
    public Optional<GetUserByEmailResponse> findUserByEmail(String email) {
        return Optional.empty();
    }
}
