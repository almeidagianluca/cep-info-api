package io.github.almeidagianluca.cep_info_api.controller.impl;

import io.github.almeidagianluca.cep_info_api.controller.CepDetailsController;
import io.github.almeidagianluca.cep_info_api.log.Loggable;
import io.github.almeidagianluca.cep_info_api.model.CepDetails;
import io.github.almeidagianluca.cep_info_api.service.CepDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepDetailsControllerImpl implements CepDetailsController {
    @Autowired
    CepDetailsService cepDetailsService;

    @GetMapping("/{cep}")
    @Loggable
    public ResponseEntity<CepDetails> getProductByCode(@PathVariable String cep) {
        return cepDetailsService.getCepDetails(cep);
    }
}
