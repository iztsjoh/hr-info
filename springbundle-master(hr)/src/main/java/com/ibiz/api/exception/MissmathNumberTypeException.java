package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class MissmathNumberTypeException extends Exception {

    private ErrorCode errorCode;
    private Object errorObject;
    private String message;

    public MissmathNumberTypeException() {
        this.errorCode = ErrorCode.MISSMATCH_NUMBER_TYPE_EXCPETION;
    }

    public MissmathNumberTypeException(Object object) {
        this.errorCode = ErrorCode.MISSMATCH_NUMBER_TYPE_EXCPETION;

        this.errorObject = object;
    }



    public MissmathNumberTypeException(String input) {

            this.errorCode = ErrorCode.MISSMATCH_NUMBER_TYPE_EXCPETION;
            this.message = input;


    }
}
