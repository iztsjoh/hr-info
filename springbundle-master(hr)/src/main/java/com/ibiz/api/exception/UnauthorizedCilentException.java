package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class UnauthorizedCilentException extends Exception {

    private ErrorCode errorCode;

    public UnauthorizedCilentException() {
        this.errorCode = ErrorCode.UNAUTHORIZED_CLIENT_ID;
    }



}
