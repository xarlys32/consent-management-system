package com.vw.consent.management.system.user.api.rest.mapper;

import com.vw.consent.management.system.user.api.rest.dto.UserCreatedResponseDTO;
import com.vw.consent.management.system.user.api.rest.dto.UserGetResponseDTO;
import com.vw.consent.management.system.user.api.rest.dto.UserUpdatedResponseDTO;
import com.vw.consent.management.system.user.application.command.CreateUserResponse;
import com.vw.consent.management.system.user.application.command.UpdateConsentResponse;
import com.vw.consent.management.system.user.application.query.GetUserByEmailResponse;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper {
    public UserCreatedResponseDTO createUserResponseToDTO(CreateUserResponse
                                                                createdUserResponse) {
        return new UserCreatedResponseDTO(createdUserResponse.id(),
                createdUserResponse.email(), createdUserResponse.consent());
    }

    public UserUpdatedResponseDTO updateConsentResponseToDTO (UpdateConsentResponse updateConsentResponse) {
        return new UserUpdatedResponseDTO(updateConsentResponse.id(),
                updateConsentResponse.email(),
                updateConsentResponse.consent());
    }
    public UserGetResponseDTO getUserByEmailQueryToDTO(GetUserByEmailResponse getUserByEmailResponse) {
        return new UserGetResponseDTO(getUserByEmailResponse.id(),
                getUserByEmailResponse.email(),
                getUserByEmailResponse.consent(),
                getUserByEmailResponse.createdAt());
    }
}
