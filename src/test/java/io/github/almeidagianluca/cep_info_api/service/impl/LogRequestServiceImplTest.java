package io.github.almeidagianluca.cep_info_api.service.impl;

import io.github.almeidagianluca.cep_info_api.repository.LogRequestRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LogRequestServiceImplTest {

    @Mock
    private LogRequestRepository logRequestRepository;

    @InjectMocks
    private LogRequestServiceImpl logRequestServiceImpl;
    @Test
    void saveLogRequest() {
        // Arrange
        String api = "getCepDetails";
        String response = "{\"cep\":\"01001-000\",\"logradouro\":\"Praça da Sé\"}";
        String status = "200";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String expectedFormattedDate = LocalDateTime.now().format(formatter);

        // Act
        logRequestServiceImpl.saveLogRequest(api, response, status);

        // Assert
        verify(logRequestRepository, times(1)).save(argThat(logRequest ->
                logRequest.getApi().equals(api) &&
                        logRequest.getResponse().equals(response) &&
                        logRequest.getStatus().equals(status) &&
                        logRequest.getRequestDate().startsWith(expectedFormattedDate.substring(0, 16))
        ));
    }
}