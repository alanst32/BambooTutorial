package com.skoogle.destkop.security;

import com.skoogle.destkop.exception.AccessDeniedException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
@Aspect
@Component
public class SecuredAspect {

    @Value("${secured.api.key.attribute}")
    private String apiKeyAttribute;

    @Value("${secured.api.key.value}")
    private String apiKeyValue;

    private String statusMessage;

    @Pointcut("@annotation(com.skoogle.desktop.security.Secured)")
    private void callAt() {
    }

    @Around("callAt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if(!checkApiKey(sra.getRequest(), sra.getResponse())){
            throw new AccessDeniedException(statusMessage);
        }

        return joinPoint.proceed();
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return sra.getRequest();
    }

    private boolean checkApiKey(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestApiKey = request.getHeader(apiKeyAttribute);

        if (StringUtils.isEmpty(requestApiKey)) {
            statusMessage = "Api-Key header missing or wrong scheme chosen";
            return false;
        }
        else if (!requestApiKey.equals(apiKeyValue)){
            statusMessage = "Service does not have sufficient permissions to access this resource";
            return false;
        }
        else {
            return true;
        }
    }

    private String generateErrorObject(String errorMessage) {
        return "{\"error\":\"" + errorMessage + "\"}";
    }
}
