package com.hr.domain;

import lombok.Getter;

@Getter
public enum ErrorCode {
    /**
     * 400 Bad Request
     */
    ROW_DOES_NOT_EXIST(4000);

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }
}