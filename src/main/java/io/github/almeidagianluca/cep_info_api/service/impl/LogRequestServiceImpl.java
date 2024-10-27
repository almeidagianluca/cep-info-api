package io.github.almeidagianluca.cep_info_api.service.impl;

import io.github.almeidagianluca.cep_info_api.model.LogRequest;
import io.github.almeidagianluca.cep_info_api.repository.LogRequestRepository;
import io.github.almeidagianluca.cep_info_api.service.LogRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LogRequestServiceImpl implements LogRequestService {
    @Autowired
    LogRequestRepository logRequestRepository;
    @Override
    public void saveLogRequest(String api, String response, String status) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedRequestDate =  LocalDateTime.now().format(formatter);

        LogRequest logRequest = LogRequest.builder()
                .requestDate(formattedRequestDate)
                .api(api)
                .status(status)
                .response(response)
                .build();
        logRequestRepository.save(logRequest);
    }
}
