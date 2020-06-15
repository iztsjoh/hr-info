package com.ibiz.api.filter;

import com.ibiz.api.exception.InvalidMessageStructureException;
import com.ibiz.api.exception.UnauthorizedCilentException;
import com.ibiz.api.service.RedisAgent;
import com.ibiz.api.utils.AES256Utils;
import com.ibiz.api.utils.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

//@Component
public class AuthFilter extends GenericFilterBean {

    @Autowired
    RedisAgent redisAgent;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*
        try {
            if (!JwtUtils.checkAccessToken((String) AES256Utils.decrypt(request.getParameter("accessToken"), redisAgent.getValue("session_key"))))
                throw new UnauthorizedCilentException();
        } catch (InvalidMessageStructureException e) {
            request.setAttribute("error", "InvalidMessageStructureException");
        } catch (ExpiredJwtException e) {
            request.setAttribute("error", "ExpiredJwtException");
        } catch (UnauthorizedCilentException e) {
            request.setAttribute("error", "UnauthorizedCilentException");
        }
*/
        chain.doFilter(request, response);
    }
}
