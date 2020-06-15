package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class DeptStateException extends Exception {

    private ErrorCode errorCode;
    private Object errorObject;
    private String message;

    public DeptStateException() {
        this.errorCode = ErrorCode.NO_DEFINITION_EXCEPTION;
    }

    public DeptStateException(Object object) {
        this.errorCode = ErrorCode.NO_DEFINITION_EXCEPTION;

        this.errorObject = object;
    }




}
