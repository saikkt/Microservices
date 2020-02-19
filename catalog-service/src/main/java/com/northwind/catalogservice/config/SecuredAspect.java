package com.northwind.catalogservice.config;

import org.aspectj.apache.bcel.classfile.Signature;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Configuration
@Aspect
public class SecuredAspect {

    @Before("@annotation(com.northwind.catalogservice.config.Secured)")
    public void validateToken(JoinPoint joinPoint) throws IllegalAccessException {
        HttpServletRequest request = getRequest();

        String authToken = request.getHeader("X-AUTH_TOKEN");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Method method = signature.getMethod();

        Secured securedAnnotation = method.getAnnotation(Secured.class);

        String scope = securedAnnotation.scope();

        System.out.println("Scope: " + scope);


        System.out.println("TOKEN : " + authToken);
        if(!scope.equals("read")||!scope.equals("write"))
            throw new IllegalAccessException();
        if(scope.equals("read")){
        if (authToken == null || !authToken.equals("abc")) {
            throw new IllegalAccessException();
        }
        }
        if(scope.equals("write")){
        if (authToken == null || !authToken.equals("def")) {
            throw new IllegalAccessException();
        }}
    }

    private HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        return requestAttributes.getRequest();

    }
}
