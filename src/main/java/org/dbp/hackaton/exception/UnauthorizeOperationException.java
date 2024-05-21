package org.dbp.hackaton.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Unauthorize operation")
public class UnauthorizeOperationException extends RuntimeException{
    public UnauthorizeOperationException(String message) {
        super(message);
    }
}
