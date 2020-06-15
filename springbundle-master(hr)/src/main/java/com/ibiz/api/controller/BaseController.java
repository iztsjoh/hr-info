package com.ibiz.api.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibiz.api.exception.InvalidMessageStructureException;
import com.ibiz.api.model.Payload;
import com.ibiz.api.service.RedisAgent;
import com.ibiz.api.utils.AES256Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public abstract class BaseController {

    @Autowired
    private RedisAgent redisAgent;

    protected Payload parsePayload(String payload, TypeToken typeToken) throws InvalidMessageStructureException {
        Gson gson  = new Gson();

        return gson.fromJson((String) AES256Utils.decrypt(payload, redisAgent.getValue("session_key")), typeToken.getType());
    }

    protected ResponseEntity composePayload(Payload payload) throws Exception {
        Gson gson  = new Gson();

        return new ResponseEntity<>(AES256Utils.encrypt(gson.toJson(payload), redisAgent.getValue("session_key")), HttpStatus.OK);
    }

}
