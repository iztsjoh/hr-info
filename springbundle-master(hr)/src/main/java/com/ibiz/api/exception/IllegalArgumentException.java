package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class
IllegalArgumentException extends Exception {

    private ErrorCode errorCode;

    public IllegalArgumentException() {
        this.errorCode = ErrorCode.ILLEGAL_ARGUMENT;
    }

}
