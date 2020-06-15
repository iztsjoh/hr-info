package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class NoHistoryException extends Exception {

    private ErrorCode errorCode;
    private Object errorObject;
    private String message;

    public NoHistoryException() {
        this.errorCode = ErrorCode.NO_HISTORY_EXCEPTION;
    }

    public NoHistoryException(Object object) {
        this.errorCode = ErrorCode.NO_HISTORY_EXCEPTION;

        this.errorObject = object;
    }



    public NoHistoryException(String input) {

            this.errorCode = ErrorCode.NO_HISTORY_EXCEPTION;
            this.message = input;


    }
}
