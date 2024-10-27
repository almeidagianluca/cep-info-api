package io.github.almeidagianluca.cep_info_api.log;

import io.github.almeidagianluca.cep_info_api.service.LogRequestService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
    @Autowired
    private LogRequestService logRequestService;

    @Around("@annotation(Loggable)")
    public Object logRequests(ProceedingJoinPoint joinPoint) throws Throwable {
        String api = joinPoint.getSignature().getName();

        ResponseEntity<?> response = (ResponseEntity<?>) joinPoint.proceed();

        String responseData = response.getBody() != null ? response.getBody().toString() : "No data";
        logRequestService.saveLogRequest(api, responseData, response.getStatusCode().toString());

        return response;
    }
}
