package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class DeletedPageException extends Exception {

    private ErrorCode errorCode;
    private Object errorObject;
    private String message;

    public DeletedPageException() {
        this.errorCode = ErrorCode.DELETED_PAGE_EXCEPTION;
    }

    public DeletedPageException(Object object) {
        this.errorCode = ErrorCode.DELETED_PAGE_EXCEPTION;

        this.errorObject = object;
    }



    public DeletedPageException(String input) {

            this.errorCode = ErrorCode.DELETED_PAGE_EXCEPTION;
            this.message = input;


    }
}
