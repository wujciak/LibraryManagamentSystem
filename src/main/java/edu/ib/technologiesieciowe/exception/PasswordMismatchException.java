package edu.ib.technologiesieciowe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PasswordMismatchException extends ResponseStatusException {
    public PasswordMismatchException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }

    public static PasswordMismatchException create() {
        return new PasswordMismatchException("Password does not match.");
    }
}
