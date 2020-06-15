package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class MissmathEmailTypeException extends Exception {

    private ErrorCode errorCode;
    private Object errorObject;
    private String message;

    public MissmathEmailTypeException() {
        this.errorCode = ErrorCode.MISSMATCH_EMAIL_TYPE_EXCPETION;
    }

    public MissmathEmailTypeException(Object object) {
        this.errorCode = ErrorCode.MISSMATCH_EMAIL_TYPE_EXCPETION;

        this.errorObject = object;
    }



    public MissmathEmailTypeException(String input) {

            this.errorCode = ErrorCode.MISSMATCH_EMAIL_TYPE_EXCPETION;
            this.message = input;


    }
}
