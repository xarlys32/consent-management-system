package com.vw.consent.management.system.user.application.handler;

import com.vw.consent.management.system.user.application.command.CreateUserCommand;
import com.vw.consent.management.system.user.application.command.CreateUserResponse;
import com.vw.consent.management.system.user.application.mapper.UserCommandMapper;
import com.vw.consent.management.system.user.domain.entity.User;
import com.vw.consent.management.system.user.domain.event.UserConsentCreateEvent;
import com.vw.consent.management.system.user.application.port.UserEventPublisher;
import com.vw.consent.management.system.user.application.port.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateUserCommandHandler {
    private final UserRepository userRepository;
    private final UserCommandMapper userCommandMapper;
    private final UserEventPublisher userEventPublisher;

    public CreateUserCommandHandler(UserRepository userRepository, UserCommandMapper userCommandMapper, UserEventPublisher userEventPublisher) {
        this.userRepository = userRepository;
        this.userCommandMapper = userCommandMapper;
        this.userEventPublisher = userEventPublisher;
    }

    @Transactional
    public CreateUserResponse createUser(CreateUserCommand createUserCommand){
        // pasar command a modelo de dominio
        User user = userCommandMapper.createUserCommandToUser(createUserCommand);
        // Validar dominio
        // recibir evento de usuario y 1º consent
        UserConsentCreateEvent createEvent = user.userCreateEvent();
        // guardar en repo si user
        insertUser(user);
        // publicar evento
        userEventPublisher.publish(createEvent);
        return userCommandMapper.userToCreateUserResponse(user);
    }

    private void insertUser(User user) {
        userRepository.createUser(user);
    }
}
