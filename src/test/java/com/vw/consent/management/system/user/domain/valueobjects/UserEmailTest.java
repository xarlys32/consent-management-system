package com.vw.consent.management.system.user.domain.valueobjects;

import com.vw.consent.management.system.user.domain.exception.InvalidUserMailException;
import com.vw.consent.management.system.user.domain.valueobject.UserEmail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UserEmailTest {

    @Test
    void userEmailCreatedWhenEmailValid() {
        String email = "usuario@dominio.com";
        UserEmail userEmail = new UserEmail(email);
        assertEquals(email, userEmail.getValue());
        assertEquals(email, userEmail.toString());
    }

    @Test
    void userEmailThrowErrorWhenEmailNotValid() {
        String invalidEmail = "usuario@@dominio";
        assertThrows(InvalidUserMailException.class, () -> new UserEmail(invalidEmail));
    }
}
