package com.vw.consent.management.system.user.domain.exception;

public class InvalidUserMailException extends RuntimeException {
    public InvalidUserMailException(String email) {
        super("Invalid email format for "+email);
    }
}
