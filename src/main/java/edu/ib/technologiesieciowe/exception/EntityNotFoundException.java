package edu.ib.technologiesieciowe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }

    public static ResponseStatusException create() {
        EntityNotFoundException exception =
                new EntityNotFoundException("Entity was not found.");
        return new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
    }
}
