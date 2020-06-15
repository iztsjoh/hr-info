package com.ibiz.api.model;

public class Response<T> {

    private T payload;
    private String state;
    private String errorCode;
    private String errorDescription;

    public T getPayload() {
        return payload;
    }

    public Response<T> setPayload(T payload) {
        this.payload = payload;
        return this;
    }

    public String getState() {
        return state;
    }

    public Response<T> setState(String state) {
        this.state = state;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Response<T> setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public Response<T> setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        return this;
    }
}
