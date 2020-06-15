package com.ibiz.api.exception;

import lombok.Getter;

@Getter
public class InvalidMessageStructureException extends Exception {

    private ErrorCode errorCode;

    public InvalidMessageStructureException() {
        this.errorCode = ErrorCode.INVALID_MESSAGE_STRUCTURE;
    }

}
