package org.example.quotations_delivery.controller;

import org.example.quotations_delivery.error.RestError;
import org.example.quotations_delivery.error.RestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice (basePackageClasses = DeliveryController.class)
public class DeliveryControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RestException.class)
    ResponseEntity<?> restException(HttpServletRequest r, Throwable t) {
        HttpStatus status = getStatus(r);
        return new ResponseEntity<>(new RestError(status.value(), t.getMessage()), status);
    }

    private HttpStatus getStatus(HttpServletRequest r) {
        Integer code = (Integer) (r.getAttribute("javax.servlet.error.status_code"));

        if (null == code) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return HttpStatus.valueOf(code);
    }
}