package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class MissmathCharactorTypeException extends Exception {

    private ErrorCode errorCode;
    private Object errorObject;
    private String message;

    public MissmathCharactorTypeException() {
        this.errorCode = ErrorCode.MISSMATCH_CHARACTOR_TYPE_EXCPETION;
    }

    public MissmathCharactorTypeException(Object object) {
        this.errorCode = ErrorCode.MISSMATCH_CHARACTOR_TYPE_EXCPETION;

        this.errorObject = object;
    }



    public MissmathCharactorTypeException(String input) {

            this.errorCode = ErrorCode.MISSMATCH_CHARACTOR_TYPE_EXCPETION;
            this.message = input;


    }
}
