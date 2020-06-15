package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class NotNullException extends Exception {

    private ErrorCode errorCode;
    private Object errorObject;
    private String message;

    public NotNullException() {
        this.errorCode = ErrorCode.NOTNULL_EXCEPTION;
    }

    public NotNullException(Object object) {
        this.errorCode = ErrorCode.NOTNULL_EXCEPTION;

        this.errorObject = object;
    }



    public NotNullException(String input) {

            this.errorCode = ErrorCode.NOTNULL_EXCEPTION;
            this.message = input;


    }
}
