package com.vw.consent.management.system.user.application.mapper;

import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;
import com.vw.consent.management.system.user.application.command.CreateUserCommand;
import com.vw.consent.management.system.user.application.command.CreateUserResponse;
import com.vw.consent.management.system.user.application.query.GetUserByEmailResponse;
import com.vw.consent.management.system.user.domain.entity.User;
import com.vw.consent.management.system.user.domain.valueobject.UserConsent;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;
import com.vw.consent.management.system.user.infrastructure.repository.postgresql.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserCommandMapper {
    public User createUserCommandToUser(CreateUserCommand createUserCommand){
        return User.builder()
                .userEmail(new UserEmail(createUserCommand.email()))
                .userConsent(new UserConsent( Map.of(
                        ConsentType.valueOf(createUserCommand.consentType()),
                        createUserCommand.enabled()
                )))
                .build();
    }

    public CreateUserResponse userToCreateUserResponse(User user) {
        return new CreateUserResponse(user.getId().getValue(),
                user.getUserEmail().getValue(),
                user.getUserConsent().asMap());
    }

    public GetUserByEmailResponse userEntityToGetUserByEmailResponse(UserEntity userEntity) {
        return new GetUserByEmailResponse(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getConsents().entrySet().stream()
                .collect(Collectors.toMap(e -> ConsentType.fromValue(e.getKey()).get(), Map.Entry::getValue)),
                userEntity.getCreatedAt()
        );
    }

}
