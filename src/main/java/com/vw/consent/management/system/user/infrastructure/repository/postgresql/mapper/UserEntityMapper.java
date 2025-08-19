package com.vw.consent.management.system.user.infrastructure.repository.postgresql.mapper;

import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;
import com.vw.consent.management.system.shared.domain.valueobject.UserId;
import com.vw.consent.management.system.user.application.query.GetUserByEmailResponse;
import com.vw.consent.management.system.user.domain.entity.User;
import com.vw.consent.management.system.user.domain.valueobject.UserConsent;
import com.vw.consent.management.system.user.domain.valueobject.UserCreatedAt;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;
import com.vw.consent.management.system.user.infrastructure.repository.postgresql.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserEntityMapper {
    public GetUserByEmailResponse userEntityToGetUserByEmailResponse(UserEntity userEntity) {
        return new GetUserByEmailResponse(userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getConsent() != null ? userEntity.getConsent().entrySet().stream()
                        .collect(Collectors.toMap(
                                e -> ConsentType.fromValue(
                                        e.getKey()).orElseThrow(() -> new IllegalArgumentException("")), Map.Entry::getValue)) : null,
                userEntity.getCreatedAt());
    }

    public UserEntity userToUserEntityInsert(User user) {
        return UserEntity.builder()
                .email(user.getUserEmail().getValue())
                .consent(user.getUserConsent() == null ? null : user.getUserConsent().asMap().entrySet().stream()
                        .collect(Collectors.toMap(
                                entry -> entry.getKey().toString(),
                                Map.Entry::getValue
                        )))
                .createdAt(user.getUserCreatedAt().getValue())
                .build();
    }

    public UserEntity userToUserEntityUpdate(User user) {
        return UserEntity.builder()
                .id(user.getId().getValue())
                .email(user.getUserEmail().getValue())
                .consent(user.getUserConsent().asMap().entrySet().stream()
                        .collect(Collectors.toMap(
                                entry -> entry.getKey().toString(),
                                Map.Entry::getValue
                        )))
                .createdAt(user.getUserCreatedAt().getValue())
                .build();
    }

    public User userEntityToUser(UserEntity userEntity) {
        return User.builder()
                .userId(new UserId(userEntity.getId()))
                .userEmail(new UserEmail(userEntity.getEmail()))
                .userConsent(userEntity.getConsent() == null ? null : new UserConsent(userEntity.getConsent().entrySet().stream().collect(Collectors.toMap(
                        e -> ConsentType.fromValue(
                                e.getKey()).orElseThrow(()-> new IllegalArgumentException("")), Map.Entry::getValue))))
                .userCreatedAt(new UserCreatedAt(userEntity.getCreatedAt()))
                .build();
    }
}
