package com.vw.consent.management.system.user.application;

import com.vw.consent.management.system.user.application.command.CreateUserCommand;
import com.vw.consent.management.system.user.domain.port.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateUserCommandHandler {
    private final UserRepository userRepository;

    public CreateUserCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void createUser(CreateUserCommand createUserCommand){
        // pasar command a modelo de dominio
        // Validar dominio
        // recibir evento de dominio
        // guardar en repo si todo ok
        // publicar evento

    }

}
