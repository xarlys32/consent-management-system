package com.vw.consent.management.system.user.domain.exception;

public class InvalidUserMail extends RuntimeException {
    public InvalidUserMail(String email) {
        super("Invalid email format for "+email);
    }
}
