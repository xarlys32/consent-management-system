package com.vw.consent.management.system.user.infrastructure.repository.postgresql.mapper;

import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;
import com.vw.consent.management.system.user.application.query.GetUserByEmailResponse;
import com.vw.consent.management.system.user.infrastructure.repository.postgresql.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserEntityMapper {
    public GetUserByEmailResponse userEntityToGetUserByEmailResponse(User userEntity) {
        return new GetUserByEmailResponse(userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getConsents().entrySet().stream()
                        .collect(Collectors.toMap(
                                e -> ConsentType.fromValue(
                                        e.getKey()).get(), Map.Entry::getValue)),
                userEntity.getCreatedAt());
    }
}
