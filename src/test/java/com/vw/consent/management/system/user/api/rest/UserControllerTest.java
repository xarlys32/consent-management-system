package com.vw.consent.management.system.user.api.rest;

import com.vw.consent.management.system.user.api.rest.dto.UserCreatedResponseDTO;
import com.vw.consent.management.system.user.api.rest.dto.UserGetView;
import com.vw.consent.management.system.user.api.rest.dto.UserUpdatedResponseDTO;
import com.vw.consent.management.system.user.api.rest.mapper.UserDTOMapper;
import com.vw.consent.management.system.user.application.command.CreateUserCommand;
import com.vw.consent.management.system.user.application.command.CreateUserResponse;
import com.vw.consent.management.system.user.application.command.UpdateUserConsentCommand;
import com.vw.consent.management.system.user.application.command.UpdateUserConsentResponse;
import com.vw.consent.management.system.user.application.handler.CreateUserCommandHandler;
import com.vw.consent.management.system.user.application.handler.GetUserByEmailQueryHandler;
import com.vw.consent.management.system.user.application.handler.UpdateUserConsentCommandHandler;
import com.vw.consent.management.system.user.application.query.GetUserByEmailQuery;
import com.vw.consent.management.system.user.application.query.GetUserByEmailResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private CreateUserCommandHandler createUserCommandHandler;
    @Mock
    private GetUserByEmailQueryHandler getUserByEmailQueryHandler;
    @Mock
    private UpdateUserConsentCommandHandler updateUserConsentCommandHandler;
    @Mock
    private UserDTOMapper userDTOMapper;

    @InjectMocks
    private UserController userController;

    @Test
    void createUser_ok() {
        CreateUserCommand command = mock(CreateUserCommand.class);
        CreateUserResponse response = mock(CreateUserResponse.class);
        UserCreatedResponseDTO dto = mock(UserCreatedResponseDTO.class);

        when(createUserCommandHandler.createUser(command)).thenReturn(response);
        when(userDTOMapper.createUserResponseToDTO(response)).thenReturn(dto);

        ResponseEntity<UserCreatedResponseDTO> result = userController.createUser(command);

        assertEquals(dto, result.getBody());
        assertEquals(200, result.getStatusCodeValue());
        verify(createUserCommandHandler).createUser(command);
        verify(userDTOMapper).createUserResponseToDTO(response);
    }

    @Test
    void getUser_ok() {
        String email = "test@mail.com";
        GetUserByEmailResponse response = mock(GetUserByEmailResponse.class);
        UserGetView dto = mock(UserGetView.class);

        when(getUserByEmailQueryHandler.getUserByEmail(any(GetUserByEmailQuery.class))).thenReturn(response);
        when(userDTOMapper.getUserByEmailResponseToDTO(response)).thenReturn(dto);

        ResponseEntity<UserGetView> result = userController.getUser(email);

        assertEquals(dto, result.getBody());
        assertEquals(200, result.getStatusCodeValue());
        verify(getUserByEmailQueryHandler).getUserByEmail(any(GetUserByEmailQuery.class));
        verify(userDTOMapper).getUserByEmailResponseToDTO(response);
    }

    @Test
    void updateUserConsent_ok() {
        UpdateUserConsentCommand command = mock(UpdateUserConsentCommand.class);
        UpdateUserConsentResponse response = mock(UpdateUserConsentResponse.class);
        UserUpdatedResponseDTO dto = mock(UserUpdatedResponseDTO.class);

        when(updateUserConsentCommandHandler.updateUserConsent(command)).thenReturn(response);
        when(userDTOMapper.updateConsentResponseToDTO(response)).thenReturn(dto);

        ResponseEntity<UserUpdatedResponseDTO> result = userController.updateUserConsent(command);

        assertEquals(dto, result.getBody());
        assertEquals(200, result.getStatusCodeValue());
        verify(updateUserConsentCommandHandler).updateUserConsent(command);
        verify(userDTOMapper).updateConsentResponseToDTO(response);
    }
}

