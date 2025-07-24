package com.vw.consent.management.system.user.api.rest;

import com.vw.consent.management.system.user.api.rest.dto.UserCreatedResponseDTO;
import com.vw.consent.management.system.user.api.rest.dto.UserGetResponseDTO;
import com.vw.consent.management.system.user.api.rest.mapper.UserDTOMapper;
import com.vw.consent.management.system.user.application.handler.CreateUserCommandHandler;
import com.vw.consent.management.system.user.application.command.CreateUserCommand;
import com.vw.consent.management.system.user.application.command.CreateUserResponse;
import com.vw.consent.management.system.user.application.query.GetUserByEmailResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final CreateUserCommandHandler createUserCommandHandler;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserCommandHandler createUserCommandHandler, UserDTOMapper userDTOMapper) {
        this.createUserCommandHandler = createUserCommandHandler;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping("/")
    public ResponseEntity<UserCreatedResponseDTO> createUser(@RequestBody CreateUserCommand createUserCommand) {
        CreateUserResponse userCreatedResponse = createUserCommandHandler.createUser(createUserCommand);
        UserCreatedResponseDTO responseDTO = userDTOMapper.createUserResponseToDTO(userCreatedResponse);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("")
    public ResponseEntity<UserGetResponseDTO> getUser(@RequestParam String email) {
        GetUserByEmailResponse getUserResponse = createUserCommandHandler.
    }
}
