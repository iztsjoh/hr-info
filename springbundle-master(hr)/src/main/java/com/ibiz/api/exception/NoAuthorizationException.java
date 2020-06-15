package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class NoAuthorizationException extends Exception {

    private ErrorCode errorCode;
    private Object errorObject;
    private String message;

    public NoAuthorizationException() {
        this.errorCode = ErrorCode.NO_AUTHORIZATION_EXCEPTION;
    }

    public NoAuthorizationException(Object object) {
        this.errorCode = ErrorCode.NO_AUTHORIZATION_EXCEPTION;

        this.errorObject = object;
    }



    public NoAuthorizationException(String input) {

            this.errorCode = ErrorCode.NO_AUTHORIZATION_EXCEPTION;
            this.message = input;


    }
}
