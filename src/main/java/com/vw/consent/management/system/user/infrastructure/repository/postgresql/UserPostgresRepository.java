package com.vw.consent.management.system.user.infrastructure.repository.postgresql;

import com.vw.consent.management.system.user.infrastructure.repository.postgresql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserPostgresRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
}
