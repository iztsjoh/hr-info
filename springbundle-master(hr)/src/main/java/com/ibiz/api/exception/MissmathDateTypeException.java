package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class MissmathDateTypeException extends Exception {

    private ErrorCode errorCode;
    private Object errorObject;
    private String message;

    public MissmathDateTypeException() {
        this.errorCode = ErrorCode.MISSMATCH_DATE_TYPE_EXCPETION;
    }

    public MissmathDateTypeException(Object object) {
        this.errorCode = ErrorCode.MISSMATCH_DATE_TYPE_EXCPETION;

        this.errorObject = object;
    }



    public MissmathDateTypeException(String input) {

            this.errorCode = ErrorCode.MISSMATCH_DATE_TYPE_EXCPETION;
            this.message = input;


    }
}
