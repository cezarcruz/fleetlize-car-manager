package com.fleetlize.webapp.gateways.rest;

import com.fleetlize.webapp.gateways.rest.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validationExceptionHandler(final MethodArgumentNotValidException ex) {

        log.error("validation error", ex);

        final BindingResult result = ex.getBindingResult();
        final FieldError fieldErrors = result.getFieldErrors().get(0);

        final ErrorResponse errorResponse = ErrorResponse.builder().message(fieldErrors.getDefaultMessage()).build();

        return ResponseEntity.badRequest().body(errorResponse);

    }
}
