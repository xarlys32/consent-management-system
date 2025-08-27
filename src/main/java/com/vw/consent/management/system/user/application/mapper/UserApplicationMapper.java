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
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserApplicationMapper {
    public User createUserCommandToUser(CreateUserCommand createUserCommand){
        return User.builder()
                .userEmail(new UserEmail(createUserCommand.email()))
                .userConsent(buildUserConsent(createUserCommand.consentType(), createUserCommand.enabled()))
                .build();
    }

    public CreateUserResponse userToCreateUserResponse(User user) {
        return new CreateUserResponse(user.getId().getValue(),
                user.getUserEmail().getValue(),
                Optional.ofNullable(user.getUserConsent())
                        .map(UserConsent::asMap)
                        .orElse(null));
    }

    public GetUserByEmailResponse userToGetUserByEmailResponse(User user) {
        return new GetUserByEmailResponse(
                user.getId().getValue(),
                user.getUserEmail().getValue(),
                user.getUserConsent().asMap(),
                user.getUserCreatedAt().getValue()
        );
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

    private UserConsent buildUserConsent(String consentType, boolean enabled) {
        if (consentType == null || consentType.isBlank()) {
            return null;
        }

        ConsentType type = ConsentType.fromValue(consentType)
                .orElseThrow(() -> new ConsentTypeNotValidException(consentType));

        return new UserConsent(Map.of(type, enabled));
    }
}
