package com.vw.consent.management.system.user.application.handler;

import com.vw.consent.management.system.user.application.mapper.UserCommandMapper;
import com.vw.consent.management.system.user.application.query.GetUserByEmailQuery;
import com.vw.consent.management.system.user.application.query.GetUserByEmailResponse;
import com.vw.consent.management.system.user.application.port.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class GetUserByEmailQueryHandler {
    private final UserRepository userRepository;
    private final UserCommandMapper userCommandMapper;

    public GetUserByEmailQueryHandler(UserRepository userRepository, UserCommandMapper userCommandMapper) {
        this.userRepository = userRepository;
        this.userCommandMapper = userCommandMapper;
    }

    public GetUserByEmailResponse getUserByEmail(GetUserByEmailQuery getUserQuery) {
       return userRepository.findUserByEmail(getUserQuery.email()).get();
    }
}
