package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class CodeOverlapException extends Exception {

    private ErrorCode errorCode;
    private Object errorObject;
    private String message;

    public CodeOverlapException() {
        this.errorCode = ErrorCode.CODE_OVERLAP_EXCEPTION;
    }

    public CodeOverlapException(Object object) {
        this.errorCode = ErrorCode.CODE_OVERLAP_EXCEPTION;

        this.errorObject = object;
    }



    public CodeOverlapException(String input) {

            this.errorCode = ErrorCode.CODE_OVERLAP_EXCEPTION;
            this.message = input;


    }
}
