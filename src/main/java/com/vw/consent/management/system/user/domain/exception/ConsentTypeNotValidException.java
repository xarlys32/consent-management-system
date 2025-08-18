package com.vw.consent.management.system.user.domain.exception;

public class ConsentTypeNotValidException extends RuntimeException {
    public ConsentTypeNotValidException(String consent) {
        super("Not valid consentType +");
    }
}
