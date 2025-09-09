package com.vw.consent.management.system.user.api.rest.exceptions;

import com.vw.consent.management.system.user.domain.exception.ConsentTypeNotValidException;
import com.vw.consent.management.system.user.domain.exception.DuplicateMailException;
import com.vw.consent.management.system.user.domain.exception.InvalidUserMailException;
import com.vw.consent.management.system.user.domain.exception.UserEmailNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionsHandler {
    @ExceptionHandler({DuplicateMailException.class})
    public ResponseEntity<String> userExistsException(DuplicateMailException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({InvalidUserMailException.class})
    public ResponseEntity<String> invalidEmailException(InvalidUserMailException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({UserEmailNotFoundException.class})
    public ResponseEntity<String> userNotFoundException(UserEmailNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ConsentTypeNotValidException.class})
    public ResponseEntity<String> consentTypeNotValid(ConsentTypeNotValidException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Invalid Data");
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}
