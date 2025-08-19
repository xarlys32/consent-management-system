package com.vw.consent.management.system.user.domain.valueobject;

import com.vw.consent.management.system.user.domain.exception.InvalidUserMailException;

import java.util.Objects;
import java.util.regex.Pattern;

public class UserEmail {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );

    private final String value;

    public UserEmail(String value) {
        if (value == null || !EMAIL_PATTERN.matcher(value).matches()) {
            throw new InvalidUserMailException(value);
        }
        this.value = value.toLowerCase();
    }

    public String getValue() { return value; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEmail userEmail = (UserEmail) o;
        return Objects.equals(value, userEmail.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
