package io.github.almeidagianluca.cep_info_api.service.impl;

import io.github.almeidagianluca.cep_info_api.client.CepDetailsClient;
import io.github.almeidagianluca.cep_info_api.model.CepDetails;
import io.github.almeidagianluca.cep_info_api.service.CepDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CepDetailsServiceImpl implements CepDetailsService {
    @Autowired
    CepDetailsClient cepDetailsClient;
    @Override
    public ResponseEntity<CepDetails> getCepDetails(String cep) {
        return cepDetailsClient.getCepDetails(cep);
    }
}
