package com.vw.consent.management.system.user.application.handler;

import com.vw.consent.management.system.user.application.command.CreateUserCommand;
import com.vw.consent.management.system.user.application.command.CreateUserResponse;
import com.vw.consent.management.system.user.application.mapper.UserApplicationMapper;
import com.vw.consent.management.system.user.domain.entity.User;
import com.vw.consent.management.system.user.domain.event.UserConsentCreateEvent;
import com.vw.consent.management.system.user.application.port.out.UserEventPublisher;
import com.vw.consent.management.system.user.application.port.out.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateUserCommandHandler {
    private final UserRepository userRepository;
    private final UserApplicationMapper userApplicationMapper;
    private final UserEventPublisher userEventPublisher;

    public CreateUserCommandHandler(UserRepository userRepository, UserApplicationMapper userApplicationMapper, UserEventPublisher userEventPublisher) {
        this.userRepository = userRepository;
        this.userApplicationMapper = userApplicationMapper;
        this.userEventPublisher = userEventPublisher;
    }

    @Transactional
    public CreateUserResponse createUser(CreateUserCommand createUserCommand) {
        User user = userApplicationMapper.createUserCommandToUser(createUserCommand);
        UserConsentCreateEvent createEvent = user.createUser();
        insertUser(user);
        if (createEvent != null) {
            publishEvent(createEvent);
        }
        return userApplicationMapper.userToCreateUserResponse(user);
    }

    private void insertUser(User user) {
        user.setId(userRepository.createUser(user).orElseThrow(() -> new RuntimeException("Error to insert")).getId());
    }


    private void publishEvent(UserConsentCreateEvent createEvent) {
        userEventPublisher.publish(createEvent);
    }
}
