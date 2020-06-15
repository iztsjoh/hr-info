package com.ibiz.api.interceptor;

import com.ibiz.api.exception.InvalidMessageStructureException;
import com.ibiz.api.exception.UnauthorizedCilentException;
import com.ibiz.api.service.RedisAgent;
import com.ibiz.api.utils.AES256Utils;
import com.ibiz.api.utils.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    RedisAgent redisAgent;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         if (!JwtUtils.checkAccessToken((String) AES256Utils.decrypt(request.getParameter("accessToken"), redisAgent.getValue("session_key")),
                redisAgent.getValue("secret_key")))
            throw new UnauthorizedCilentException();

        return super.preHandle(request, response, handler);
    }
}
