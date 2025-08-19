package com.vw.consent.management.system.consent.domain.exceptions;

public class UserIdNotFoundException extends RuntimeException {
    public UserIdNotFoundException() {
        super("User not found");
    }
}
