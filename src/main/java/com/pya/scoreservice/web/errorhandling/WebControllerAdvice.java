package com.pya.scoreservice.web.errorhandling;

import com.mongodb.MongoWriteException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

@ControllerAdvice
public class WebControllerAdvice {

  @ExceptionHandler({ IllegalArgumentException.class })
  public ResponseEntity<?> handleBadRequests(final Throwable throwable, final ServletWebRequest req) {
    return create(HttpStatus.BAD_REQUEST, throwable.getMessage(), req.getRequest().getRequestURI());
  }

  @ExceptionHandler({ NullPointerException.class })
  public ResponseEntity<?> handleNullPointerException(final Throwable throwable, final ServletWebRequest req) {
    return create(HttpStatus.INTERNAL_SERVER_ERROR, throwable.getMessage(), req.getRequest().getRequestURI());
  }

  @ExceptionHandler({ MongoWriteException.class })
  public ResponseEntity<?> handleDuplicatesEntries(final Throwable throwable, final ServletWebRequest req) {
    return create(HttpStatus.BAD_REQUEST, throwable.getMessage(), req.getRequest().getRequestURI());
  }

  private ResponseEntity<ErrorDto> create(HttpStatus status, String msg, String req) {
    return ResponseEntity.status(status).body(new ErrorDto(msg, req));
  }

  @Getter
  @Setter
  @AllArgsConstructor
  private class ErrorDto {

    private String message;
    private String RequestUri;
  }
}
