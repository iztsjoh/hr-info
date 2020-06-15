package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class DateOverlapException extends Exception {

    private ErrorCode errorCode;
    private Object errorObject;
    private String message;

    public DateOverlapException() {
        this.errorCode = ErrorCode.DATE_OVERLAP_EXCEPTION;
    }

    public DateOverlapException(Object object) {
        this.errorCode = ErrorCode.DATE_OVERLAP_EXCEPTION;

        this.errorObject = object;
    }



    public DateOverlapException(String input) {

            this.errorCode = ErrorCode.DATE_OVERLAP_EXCEPTION;
            this.message = input;


    }
}
