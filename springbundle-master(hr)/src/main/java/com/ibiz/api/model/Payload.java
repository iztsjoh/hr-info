package com.ibiz.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payload<T> {

    private AccountVO accountVO;
    private T dto;

    public Payload() {

    }

    public Payload(T dto) {
        this.dto = dto;
    }

    public Payload(AccountVO accountVO, T dto) {
        this.accountVO = accountVO;
        this.dto = dto;
    }

    public T getDto() {
        return dto;
    }

    public void setDto(T dto) {
        this.dto = dto;
    }

    public AccountVO getAccountVO() {
        return accountVO;
    }

    public void setAccountVO(AccountVO accountVO) {
        this.accountVO = accountVO;
    }
}
