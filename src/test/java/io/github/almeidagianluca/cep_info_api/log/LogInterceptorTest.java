package io.github.almeidagianluca.cep_info_api.log;

import io.github.almeidagianluca.cep_info_api.service.LogRequestService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LogInterceptorTest {
    @Mock
    private LogRequestService logRequestService;
    @Mock
    private ProceedingJoinPoint joinPoint;
    @Mock
    private Signature signature;
    @InjectMocks
    private LogInterceptor logInterceptor;
    @Test
    void logRequests() throws Throwable {
        // Arrange
        String expectedApi = "mockMethod";
        String expectedResponseData = "{\"cep\":\"01001-000\",\"logradouro\":\"Praça da Sé\"}";
        HttpStatus expectedStatus = HttpStatus.OK;
        when(joinPoint.getSignature()).thenReturn(signature);
        when(joinPoint.getSignature().getName()).thenReturn(expectedApi);
        when(joinPoint.proceed()).thenReturn(new ResponseEntity<>(expectedResponseData, expectedStatus));

        // Act
        Object result = logInterceptor.logRequests(joinPoint);

        // Assert
        assertEquals(expectedResponseData, ((ResponseEntity<?>) result).getBody());
        verify(logRequestService, times(1)).saveLogRequest(
                expectedApi,
                expectedResponseData,
                expectedStatus.toString()
        );
    }
}