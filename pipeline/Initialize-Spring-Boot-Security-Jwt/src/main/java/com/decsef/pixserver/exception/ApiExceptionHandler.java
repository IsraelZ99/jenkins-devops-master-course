package com.decsef.pixserver.exception;

import com.decsef.pixserver.exception.accessDenied.ApiUnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiUnauthorizedException.class})
    public ResponseEntity<Object> handleUnauthorizedException(ApiUnauthorizedException e) {
        HttpStatus unauthorized = HttpStatus.LOCKED;
        ApiException unauthorizedException = new ApiException("No puedes acceder al recurso.", e.getMessage(), unauthorized,
                ZonedDateTime.now(ZoneId.of("America/Mexico_City")));
        return new ResponseEntity<>(unauthorizedException, unauthorized);
    }

}
