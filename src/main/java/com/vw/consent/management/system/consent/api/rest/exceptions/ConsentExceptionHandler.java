package com.vw.consent.management.system.consent.api.rest.exceptions;

import com.vw.consent.management.system.consent.domain.exceptions.UserIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConsentExceptionHandler {
    @ExceptionHandler({UserIdNotFoundException.class})
    public ResponseEntity<String> userNotExistsException(UserIdNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> illegalIdArgument(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
