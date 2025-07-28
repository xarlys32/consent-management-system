package com.vw.consent.management.system.user.application.handler;

import com.vw.consent.management.system.user.application.mapper.UserApplicationMapper;
import com.vw.consent.management.system.user.application.query.GetUserByEmailQuery;
import com.vw.consent.management.system.user.application.query.GetUserByEmailResponse;
import com.vw.consent.management.system.user.application.port.out.UserRepository;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;
import org.springframework.stereotype.Service;

@Service
public class GetUserByEmailQueryHandler {
    private final UserRepository userRepository;
    private final UserApplicationMapper userApplicationMapper;

    public GetUserByEmailQueryHandler(UserRepository userRepository, UserApplicationMapper userApplicationMapper) {
        this.userRepository = userRepository;
        this.userApplicationMapper = userApplicationMapper;
    }

    public GetUserByEmailResponse getUserByEmail(GetUserByEmailQuery getUserQuery) {
       return userApplicationMapper.userToGetUserByEmailResponse(userRepository.findUserByEmail(new UserEmail(getUserQuery.email())).get());
    }
}
