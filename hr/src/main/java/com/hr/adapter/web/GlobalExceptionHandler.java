package com.hr.adapter.web;

import com.hr.application.dto.ExceptionDTO;
import com.hr.domain.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO handleBadRequestException(BadRequestException exception) {
        return new ExceptionDTO(exception.getErrorCode(), exception.getMessage());
    }
}
