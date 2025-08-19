package com.vw.consent.management.system.user.application.mapper;

import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;
import com.vw.consent.management.system.user.application.command.CreateUserCommand;
import com.vw.consent.management.system.user.application.command.CreateUserResponse;
import com.vw.consent.management.system.user.application.command.UpdateUserConsentCommand;
import com.vw.consent.management.system.user.application.command.UpdateUserConsentResponse;
import com.vw.consent.management.system.user.application.query.GetUserByEmailResponse;
import com.vw.consent.management.system.user.domain.entity.User;
import com.vw.consent.management.system.user.domain.exception.ConsentTypeNotValidException;
import com.vw.consent.management.system.user.domain.valueobject.UserConsent;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserApplicationMapper {
    public User createUserCommandToUser(CreateUserCommand createUserCommand){
        return User.builder()
                .userEmail(new UserEmail(createUserCommand.email()))
                .userConsent(createUserCommand.consentType().isEmpty() ? null : new UserConsent( Map.of(
                        ConsentType.fromValue(createUserCommand.consentType()).orElseThrow(() -> new ConsentTypeNotValidException(createUserCommand.consentType())),
                        createUserCommand.enabled()
                )))
                .build();
    }

    public CreateUserResponse userToCreateUserResponse(User user) {
        return new CreateUserResponse(user.getId().getValue(),
                user.getUserEmail().getValue(),
                user.getUserConsent()!= null ? user.getUserConsent().asMap() : null);
    }

    public GetUserByEmailResponse userToGetUserByEmailResponse(User user) {
        return new GetUserByEmailResponse(
                user.getId().getValue(),
                user.getUserEmail().getValue(),
                user.getUserConsent().asMap(),
                user.getUserCreatedAt().getValue()
        );
    }

    public User updateUserConsentCommandToUser(UpdateUserConsentCommand updateUserConsentCommand) {
        return com.vw.consent.management.system.user.domain.entity.User.builder()
                .userEmail(new UserEmail(updateUserConsentCommand.email()))
                .userConsent(new UserConsent(Map.of(ConsentType.fromValue(
                        updateUserConsentCommand.consentType()).orElseThrow(() -> new IllegalArgumentException("Invalid consent type: "
                        + updateUserConsentCommand.consentType())), updateUserConsentCommand.enabled())))
                .build();
    }

    public UpdateUserConsentResponse userToUpdateUserConsentResponse(User user) {
        return new UpdateUserConsentResponse(
                user.getId().getValue(),
                user.getUserEmail().getValue(),
                user.getUserConsent().asMap().entrySet().stream()
                        .collect(Collectors.toMap(
                                e -> e.getKey().name(), Map.Entry::getValue))
        );
    }

}
