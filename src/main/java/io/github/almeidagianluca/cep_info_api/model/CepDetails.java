package io.github.almeidagianluca.cep_info_api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CepDetails {
    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String complemento;
    private String regiao;
    private String ddd;
}
