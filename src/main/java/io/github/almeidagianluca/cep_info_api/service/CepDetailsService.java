package io.github.almeidagianluca.cep_info_api.service;

import io.github.almeidagianluca.cep_info_api.model.CepDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface CepDetailsService {
    ResponseEntity<CepDetails> getCepDetails(String cep);
}
