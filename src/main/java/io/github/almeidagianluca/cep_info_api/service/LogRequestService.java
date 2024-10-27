package io.github.almeidagianluca.cep_info_api.service;

public interface LogRequestService {
    void saveLogRequest(String api, String response, String status);
}
