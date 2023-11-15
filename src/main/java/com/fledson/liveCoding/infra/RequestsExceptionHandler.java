package com.fledson.liveCoding.infra;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class RequestsExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity treat404(EntityNotFoundException err, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError(
                Instant.now(),
                status.value(),
                "Resource not found",
                err.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(error);
    }

}
