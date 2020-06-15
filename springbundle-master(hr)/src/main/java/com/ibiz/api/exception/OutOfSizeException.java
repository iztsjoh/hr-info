package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class OutOfSizeException extends Exception {

    private ErrorCode errorCode;
    private Object errorObject;
    private String message;

    public OutOfSizeException() {
        this.errorCode = ErrorCode.OUTOFSIZE_EXCEPTION;
    }

    public OutOfSizeException(Object object) {
        this.errorCode = ErrorCode.OUTOFSIZE_EXCEPTION;

        this.errorObject = object;
    }



    public OutOfSizeException(String input) {

            this.errorCode = ErrorCode.OUTOFSIZE_EXCEPTION;
            this.message = input;


    }
}
