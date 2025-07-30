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
                userEntity.getConsent().entrySet().stream()
                        .collect(Collectors.toMap(
                                e -> ConsentType.fromValue(
                                        e.getKey()).get(), Map.Entry::getValue)),
                userEntity.getCreatedAt());
    }

    public UserEntity userToUserEntity(User user) {
        return new UserEntity(user.getId().getValue(), user.getUserEmail().getValue(),
                user.getUserConsent().asMap().entrySet().stream()
                        .collect(Collectors.toMap(
                e ->  e.getKey().getValue(), Map.Entry::getValue)),
                user.getUserCreatedAt().getValue());
    }

    public User userEntityToUser(UserEntity userEntity) {
        return User.builder()
                .userId(new UserId(userEntity.getId()))
                .userEmail(new UserEmail(userEntity.getEmail()))
                .userConsent(new UserConsent(userEntity.getConsent().entrySet().stream().collect(Collectors.toMap(
                        e -> ConsentType.fromValue(
                                e.getKey()).get(), Map.Entry::getValue))))
                .userCreatedAt(new UserCreatedAt(userEntity.getCreatedAt()))
                .build();
    }
}
