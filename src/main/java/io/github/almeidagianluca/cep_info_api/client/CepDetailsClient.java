package io.github.almeidagianluca.cep_info_api.client;

import io.github.almeidagianluca.cep_info_api.model.CepDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cep-details", url = "${cep-details.client.url}")
public interface CepDetailsClient {

    @GetMapping("/cep/{cep}")
    ResponseEntity<CepDetails> getCepDetails(@PathVariable("cep") String cep);
}
