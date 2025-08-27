package com.vw.consent.management.system.user.application.handler;

import com.vw.consent.management.system.user.application.command.CreateUserCommand;
import com.vw.consent.management.system.user.application.command.CreateUserResponse;
import com.vw.consent.management.system.user.application.mapper.UserApplicationMapper;
import com.vw.consent.management.system.user.application.port.out.UserEventPublisher;
import com.vw.consent.management.system.user.application.port.out.UserRepository;
import com.vw.consent.management.system.user.domain.entity.User;
import com.vw.consent.management.system.user.domain.event.UserConsentCreateEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateUserCommandHandlerTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserApplicationMapper userApplicationMapper;
    @Mock
    private UserEventPublisher userEventPublisher;

    @InjectMocks
    private CreateUserCommandHandler handler;

    @Mock
    private CreateUserCommand command;
    @Mock
    private User user;
    @Mock
    private UserConsentCreateEvent event;
    @Mock
    private CreateUserResponse response;

    @BeforeEach
    void setUp() {
        // MockitoAnnotations.openMocks(this); // No necesario con @ExtendWith(MockitoExtension.class)
    }

    @Test
    public void createUserWhenReceiveCommand() {
        when(userApplicationMapper.createUserCommandToUser(command)).thenReturn(user);
        when(user.createUser()).thenReturn(event);
        when(userRepository.createUser(user)).thenReturn(Optional.of(user));
        when(userApplicationMapper.userToCreateUserResponse(user)).thenReturn(response);

        CreateUserResponse result = handler.createUser(command);

        assertEquals(response, result);
        verify(userEventPublisher).publish(event);
        verify(userRepository).createUser(user);
    }

    @Test
    public void createUserThrowAndErrorWhenEmailExists() {
        when(userApplicationMapper.createUserCommandToUser(command)).thenReturn(user);
        when(user.createUser()).thenReturn(event);
        when(userRepository.createUser(user)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> handler.createUser(command));
        assertEquals("Error to insert", ex.getMessage());
        verify(userRepository).createUser(user);
        verify(userEventPublisher, never()).publish(any());
    }
}
