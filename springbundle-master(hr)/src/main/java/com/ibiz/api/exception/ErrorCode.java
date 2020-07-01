package com.ibiz.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    SYSTEM_FAILURE(HttpStatus.INTERNAL_SERVER_ERROR, "500", "System error"),
    INVALID_MESSAGE_STRUCTURE(HttpStatus.PRECONDITION_FAILED, "100", "Invalid message structure."),
    RESOURCE_ACCESS_DENIED(HttpStatus.UNAUTHORIZED, "200", "Access is denied."),
    UNAUTHORIZED_CLIENT_ID(HttpStatus.UNAUTHORIZED, "201", "The client id is Unregistered"),
    INVALID_INPUT_VALUE(HttpStatus.INTERNAL_SERVER_ERROR, "400", "Invalid Input Value"),
    ACCESS_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "202", "The access token is expired"),
    ILLEGAL_ARGUMENT(HttpStatus.INTERNAL_SERVER_ERROR, "000", "Illegal Argument"),

    NO_DEFINITION_EXCEPTION(HttpStatus.UNAUTHORIZED, ExceptionCode.NO_DEFINITION_EXCEPTION, ExceptionCode.NO_DEFINITION_EXCEPTION_MESSAGE),
    NOTNULL_EXCEPTION(HttpStatus.UNAUTHORIZED, ExceptionCode.NOTNULL_EXCEPTION,ExceptionCode.NOTNULL_EXCEPTION_MESSAGE),
    OUTOFSIZE_EXCEPTION(HttpStatus.UNAUTHORIZED, ExceptionCode.OUTOFSIZE_EXCEPTION,ExceptionCode.OUTOFSIZE_EXCEPTION_MESSAGE),
    CODE_OVERLAP_EXCEPTION(HttpStatus.UNAUTHORIZED, ExceptionCode.CODE_OVERLAP_EXCEPTION,ExceptionCode.CODE_OVERLAP_EXCEPTION_MESSAGE),
    CODE_NOT_EQUAL_EXCEPTION(HttpStatus.UNAUTHORIZED, ExceptionCode.CODE_NOT_EQUAL_EXCEPTION,ExceptionCode.CODE_NOT_EQUAL_EXCEPTION_MESSAGE),
    NO_AUTHORIZATION_EXCEPTION(HttpStatus.UNAUTHORIZED, ExceptionCode.NO_AUTHORIZATION_EXCEPTION,ExceptionCode.NO_AUTHORIZATION_EXCEPTION_MESSAGE),
    DELETED_PAGE_EXCEPTION(HttpStatus.UNAUTHORIZED, ExceptionCode.DELETED_PAGE_EXCEPTION, ExceptionCode.DELETED_PAGE_EXCEPTION_MESSAGE),
    MISSMATCH_EMAIL_TYPE_EXCPETION(HttpStatus.UNAUTHORIZED, ExceptionCode.MISSMATCH_EMAIL_TYPE_EXCPETION, ExceptionCode.MISSMATCH_EMAIL_TYPE_EXCPETION_MESSAGE),
    MISSMATCH_DATE_TYPE_EXCPETION(HttpStatus.UNAUTHORIZED, ExceptionCode.MISSMATCH_DATE_TYPE_EXCPETION, ExceptionCode.MISSMATCH_DATE_TYPE_EXCPETION_MESSAGE),
    MISSMATCH_NUMBER_TYPE_EXCPETION(HttpStatus.UNAUTHORIZED, ExceptionCode.MISSMATCH_NUMBER_TYPE_EXCPETION, ExceptionCode.MISSMATCH_EMAIL_TYPE_EXCPETION_MESSAGE),
    MISSMATCH_CHARACTOR_TYPE_EXCPETION(HttpStatus.UNAUTHORIZED, ExceptionCode.MISSMATCH_CHARACTOR_TYPE_EXCPETION, ExceptionCode.MISSMATCH_CHARACTOR_TYPE_EXCPETION_MESSAGE),
    DATE_OVERLAP_EXCEPTION(HttpStatus.UNAUTHORIZED, ExceptionCode.DATE_OVERLAP_EXCEPTION, ExceptionCode.DATE_OVERLAP_EXCEPTION_MESSAGE),
    NO_HISTORY_EXCEPTION(HttpStatus.UNAUTHORIZED, ExceptionCode.NO_HISTORY_EXCEPTION, ExceptionCode.NO_HISTORY_EXCEPTION_MESSAGE)


    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

    private ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }


}
