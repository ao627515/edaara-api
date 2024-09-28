package com.forcen.edaara.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class RequestException  extends RuntimeException {
    private final @Getter HttpStatus httpStatus;

    public RequestException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }
}