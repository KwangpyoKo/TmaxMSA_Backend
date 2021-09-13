package com.hr.application.dto;

import com.hr.domain.ErrorCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ExceptionDTO {
    private final Integer errorCode;
    private final String message;
    private final LocalDateTime timeStamp;

    public ExceptionDTO(ErrorCode errorCode, String message) {
        this.errorCode = errorCode.getCode();
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }
}
