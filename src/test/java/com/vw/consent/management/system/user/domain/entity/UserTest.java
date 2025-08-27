package com.vw.consent.management.system.user.domain.entity;

import com.vw.consent.management.system.shared.domain.valueobject.UserId;
import com.vw.consent.management.system.user.domain.event.UserConsentCreateEvent;
import com.vw.consent.management.system.user.domain.valueobject.UserConsent;
import com.vw.consent.management.system.user.domain.valueobject.UserCreatedAt;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)

public class UserTest {
    @Test
    void createUser_shouldReturnEvent() {
        // Arrange
        UserId userId = new UserId(UUID.randomUUID());
        UserEmail userEmail = new UserEmail("test@mail.com");
        UserConsent userConsent = new UserConsent(Map.of("sms_notifications", true));
        UserCreatedAt userCreatedAt = new UserCreatedAt(Instant.now());

        User user = User.builder()
                .userId(userId)
                .userEmail(userEmail)
                .userConsent(userConsent)
                .userCreatedAt(userCreatedAt)
                .build();

        // Act
        UserConsentCreateEvent event = user.createUser();

        // Assert
        assertNotNull(event);
        assertEquals(userId.getValue(), event.getUserId());
        assertEquals(userEmail.getValue(), event.getEmail());
        assertEquals(userConsent.asMap(), event.getConsents());
        assertNotNull(event.getCreatedAt());
    }

    @Test
    void getters_shouldReturnCorrectValues() {
        UserId userId = new UserId(UUID.randomUUID());
        UserEmail userEmail = new UserEmail("user@mail.com");
        UserConsent userConsent = new UserConsent(Map.of("sms_notifications", false));
        UserCreatedAt userCreatedAt = new UserCreatedAt(Instant.now());

        User user = User.builder()
                .userId(userId)
                .userEmail(userEmail)
                .userConsent(userConsent)
                .userCreatedAt(userCreatedAt)
                .build();

        assertEquals(userId, user.getId());
        assertEquals(userEmail, user.getUserEmail());
        assertEquals(userConsent, user.getUserConsent());
        assertEquals(userCreatedAt, user.getUserCreatedAt());
    }
}
