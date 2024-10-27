package io.github.almeidagianluca.cep_info_api.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "logs")
@Builder
public class LogRequest {
    private String requestDate;
    private String api;
    private String status;
    private String response;
}
