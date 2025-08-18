package com.vw.consent.management.system.user.domain.exception;

public class DuplicateMailException extends RuntimeException {
    public DuplicateMailException(String email) {
        super("The user with email "+email+" exists");
    }
}
