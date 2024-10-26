package io.github.almeidagianluca.cep_info_api.controller;

import io.github.almeidagianluca.cep_info_api.model.CepDetails;
import org.springframework.http.ResponseEntity;

public interface CepDetailsController {

    ResponseEntity<CepDetails> getProductByCode(String cep);
}
