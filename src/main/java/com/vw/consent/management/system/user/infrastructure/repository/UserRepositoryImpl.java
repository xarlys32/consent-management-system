package com.vw.consent.management.system.user.infrastructure.repository;
import com.vw.consent.management.system.user.domain.entity.User;
import com.vw.consent.management.system.user.application.port.out.UserRepository;
import com.vw.consent.management.system.user.domain.exception.DuplicateMailException;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;
import com.vw.consent.management.system.user.infrastructure.repository.postgresql.UserPostgresRepository;
import com.vw.consent.management.system.user.infrastructure.repository.postgresql.mapper.UserEntityMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepositoryImpl implements UserRepository {

    private final UserPostgresRepository userPostgresRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryImpl(UserPostgresRepository userPostgresRepository, UserEntityMapper userEntityMapper) {
        this.userPostgresRepository = userPostgresRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public Optional<User> createUser(User user) {
        if (findUserByEmail(user.getUserEmail()).isPresent()) {
            throw new DuplicateMailException(user.getUserEmail().getValue());
        }
        return Optional.ofNullable(userEntityMapper.userEntityToUser(
                userPostgresRepository.save(userEntityMapper.userToUserEntityInsert(user))));
    }

    @Override
    public User updateConsentUser(User user) {
        return userEntityMapper.userEntityToUser(
                userPostgresRepository.save(userEntityMapper.userToUserEntityUpdate(user)));
    }

    @Override
    public Optional<User> findUserByEmail(UserEmail userEmail) {
        return userPostgresRepository.findByEmail(userEmail.getValue()).map(userEntityMapper::userEntityToUser);
    }

}
