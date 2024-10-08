package com.forcen.edaara.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EntityNotFoundException extends RuntimeException {
  private final HttpStatus httpStatus;

  public EntityNotFoundException(String message) {
    super(message);
    this.httpStatus = HttpStatus.NOT_FOUND;
  }
}
