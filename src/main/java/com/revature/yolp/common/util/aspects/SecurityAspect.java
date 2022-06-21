package com.revature.yolp.common.util.aspects;

import com.revature.yolp.auth.TokenService;
import com.revature.yolp.common.custom_exceptions.AuthenticationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.annotation.Annotation;

@Aspect
@Component
public class SecurityAspect {

    private final TokenService tokenService;

    @Autowired
    public SecurityAspect(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Order(1)
    @Before("@annotation(com.revature.yolp.common.util.web.Authenticated)")
    public void requireAuthentication() {
        if (!sessionExists()) throw new AuthenticationException("No session token found.");
    }

    private <T extends Annotation> T getAnnotationFromJoinPoint(JoinPoint jp, Class<T> annotationType) {
        return ((MethodSignature) jp.getSignature()).getMethod().getAnnotation(annotationType);
    }

    private boolean sessionExists() {
        String token = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getHeader("Authorization");
        System.out.println(token);
        return tokenService.isTokenValid(token);
    }
}