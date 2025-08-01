package com.vw.consent.management.system.user.api.rest;

import com.vw.consent.management.system.user.api.rest.dto.UserCreatedResponseDTO;
import com.vw.consent.management.system.user.api.rest.dto.UserGetResponseDTO;
import com.vw.consent.management.system.user.api.rest.dto.UserUpdatedResponseDTO;
import com.vw.consent.management.system.user.api.rest.mapper.UserDTOMapper;
import com.vw.consent.management.system.user.application.command.UpdateUserConsentCommand;
import com.vw.consent.management.system.user.application.handler.CreateUserCommandHandler;
import com.vw.consent.management.system.user.application.command.CreateUserCommand;
import com.vw.consent.management.system.user.application.command.CreateUserResponse;
import com.vw.consent.management.system.user.application.handler.GetUserByEmailQueryHandler;
import com.vw.consent.management.system.user.application.handler.UpdateUserConsentCommandHandler;
import com.vw.consent.management.system.user.application.query.GetUserByEmailQuery;
import com.vw.consent.management.system.user.application.query.GetUserByEmailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final CreateUserCommandHandler createUserCommandHandler;
    private final GetUserByEmailQueryHandler getUserByEmailQueryHandler;
    private final UpdateUserConsentCommandHandler updateUserConsentCommandHandler;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserCommandHandler createUserCommandHandler, GetUserByEmailQueryHandler getUserByEmailQueryHandler, UpdateUserConsentCommandHandler
            updateUserConsentCommandHandler, UserDTOMapper userDTOMapper) {
        this.createUserCommandHandler = createUserCommandHandler;
        this.getUserByEmailQueryHandler = getUserByEmailQueryHandler;
        this.updateUserConsentCommandHandler = updateUserConsentCommandHandler;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping("/")
    public ResponseEntity<UserCreatedResponseDTO> createUser(@RequestBody CreateUserCommand createUserCommand) {
        CreateUserResponse userCreatedResponse = createUserCommandHandler.createUser(createUserCommand);
        UserCreatedResponseDTO responseDTO = userDTOMapper.createUserResponseToDTO(userCreatedResponse);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/")
    public ResponseEntity<UserGetResponseDTO> getUser(@RequestParam String email) {
        GetUserByEmailResponse getUserResponse = getUserByEmailQueryHandler.getUserByEmail(new GetUserByEmailQuery(email));
        UserGetResponseDTO responseDTO = userDTOMapper.getUserByEmailResponseToDTO(getUserResponse);
        return ResponseEntity.ok(responseDTO);

    }

    @PutMapping("/")
    public ResponseEntity<UserUpdatedResponseDTO> updateUserConsent(@RequestBody UpdateUserConsentCommand updateConsentCommand) {
        CreateUserResponse userCreatedResponse = updateUserConsentCommandHandler.updateUserConsent(updateConsentCommand);
        UserUpdatedResponseDTO responseDTO = userDTOMapper.updateConsentResponseToDTO(userCreatedResponse);
        return ResponseEntity.ok(responseDTO);
    }
}
