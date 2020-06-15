package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class CodeNotEqualException extends Exception {

    private ErrorCode errorCode;
    private Object errorObject;
    private String message;

    public CodeNotEqualException() {
        this.errorCode = ErrorCode.CODE_NOT_EQUAL_EXCEPTION;
    }

    public CodeNotEqualException(Object object) {
        this.errorCode = ErrorCode.CODE_NOT_EQUAL_EXCEPTION;

        this.errorObject = object;
    }



    public CodeNotEqualException(String input) {

            this.errorCode = ErrorCode.CODE_NOT_EQUAL_EXCEPTION;
            this.message = input;


    }
}
