package com.vw.consent.management.system.user.api.rest.mapper;

import com.vw.consent.management.system.user.api.rest.dto.UserCreatedResponseDTO;
import com.vw.consent.management.system.user.api.rest.dto.UserGetResponseDTO;
import com.vw.consent.management.system.user.api.rest.dto.UserUpdatedResponseDTO;
import com.vw.consent.management.system.user.application.command.CreateUserResponse;
import com.vw.consent.management.system.user.application.command.UpdateUserConsentResponse;
import com.vw.consent.management.system.user.application.query.GetUserByEmailResponse;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserDTOMapper {
    public UserCreatedResponseDTO createUserResponseToDTO(CreateUserResponse
                                                                createdUserResponse) {
        return new UserCreatedResponseDTO(createdUserResponse.id(),
                createdUserResponse.email(), createdUserResponse.consent());
    }

    public UserUpdatedResponseDTO updateConsentResponseToDTO (UpdateUserConsentResponse updateUserConsentResponse) {
        return new UserUpdatedResponseDTO(updateUserConsentResponse.id(),
                updateUserConsentResponse.email(),
                updateUserConsentResponse.consent());
    }
    public UserGetResponseDTO getUserByEmailResponseToDTO(GetUserByEmailResponse getUserByEmailResponse) {
        return new UserGetResponseDTO(getUserByEmailResponse.id(),
                getUserByEmailResponse.email(),
                getUserByEmailResponse.consent().entrySet().stream()
                        .collect(Collectors.toMap(e -> e.getKey().name(), Map.Entry::getValue)),
                getUserByEmailResponse.createdAt());
    }

}
