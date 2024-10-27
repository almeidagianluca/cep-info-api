package io.github.almeidagianluca.cep_info_api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CepDetails {
    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String additionalInfo;
    private String region;
    private String areaCode;
}
