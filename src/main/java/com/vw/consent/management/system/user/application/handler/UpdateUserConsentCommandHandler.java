package com.vw.consent.management.system.user.application.handler;

import com.vw.consent.management.system.shared.domain.valueobject.ConsentType;
import com.vw.consent.management.system.user.application.command.UpdateUserConsentCommand;
import com.vw.consent.management.system.user.application.command.UpdateUserConsentResponse;
import com.vw.consent.management.system.user.application.mapper.UserApplicationMapper;
import com.vw.consent.management.system.user.application.port.out.UserEventPublisher;
import com.vw.consent.management.system.user.application.port.out.UserRepository;
import com.vw.consent.management.system.user.domain.entity.User;
import com.vw.consent.management.system.user.domain.event.UserConsentUpdateEvent;
import com.vw.consent.management.system.user.domain.valueobject.UserConsent;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class UpdateUserConsentCommandHandler {

    private final UserRepository userRepository;
    private final UserApplicationMapper userApplicationMapper;
    private final UserEventPublisher userEventPublisher;

    public UpdateUserConsentCommandHandler(UserRepository userRepository, UserApplicationMapper userApplicationMapper, UserEventPublisher userEventPublisher) {
        this.userRepository = userRepository;
        this.userApplicationMapper = userApplicationMapper;
        this.userEventPublisher = userEventPublisher;
    }

    @Transactional
    public UpdateUserConsentResponse updateUserConsent(UpdateUserConsentCommand updateUserConsentCommand) {
        User user = userRepository.findUserByEmail(new UserEmail(updateUserConsentCommand.email())).orElseThrow(() -> new NoSuchElementException(""));
        UserConsentUpdateEvent userConsentUpdateEvent = user.updateUserConsent(new UserConsent(Map.of(
                ConsentType.fromValue(updateUserConsentCommand.consentType()).orElseThrow(() -> new NoSuchElementException("")),
                updateUserConsentCommand.enabled()
        )));
        updateUserConsent(user);
        publishEvent(userConsentUpdateEvent);
        return userApplicationMapper.userToUpdateUserConsentResponse(user);
    }

    private void updateUserConsent(User user) {
        userRepository.updateConsentUser(user);
    }

    private void publishEvent(UserConsentUpdateEvent userConsentUpdateEvent) {
        userEventPublisher.publish(userConsentUpdateEvent);
    }
}
