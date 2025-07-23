package com.vw.consent.management.system.user.application.mapper;

import com.vw.consent.management.system.user.application.command.CreateUserCommand;
import com.vw.consent.management.system.user.domain.entity.User;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;
import org.springframework.stereotype.Component;

@Component
public class UserCommandMapper {
    public User createUserCommandToUser(CreateUserCommand createUserCommand){
        return User.builder()
                .userEmail(new UserEmail())
                .build();
    }
}
