package io.github.almeidagianluca.cep_info_api.controller.impl;

import io.github.almeidagianluca.cep_info_api.model.CepDetails;
import io.github.almeidagianluca.cep_info_api.service.CepDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(MockitoExtension.class)
class CepDetailsControllerImplTest {

    @InjectMocks
    private CepDetailsControllerImpl cepDetailsController;

    @Mock
    private CepDetailsService cepDetailsService;

    @Test
    void getProductByCode() {
        // Arrange
        String cep = "01001-000";
        CepDetails expectedDetails = CepDetails.builder()
                .cep(cep)
                .state("SP")
                .city("São Paulo")
                .neighborhood("Sé")
                .street("Praça da Sé")
                .additionalInfo("lado ímpar")
                .region("Sudeste")
                .areaCode("11")
                .build();

        ResponseEntity<CepDetails> responseEntity = new ResponseEntity<>(expectedDetails, OK);

        when(cepDetailsService.getCepDetails(cep)).thenReturn(responseEntity);

        // Act
        ResponseEntity<CepDetails> actualResponse = cepDetailsController.getProductByCode(cep);

        // Assert
        verify(cepDetailsService, times(1)).getCepDetails(cep);
        assertEquals(expectedDetails, actualResponse.getBody());
        assertEquals(OK, actualResponse.getStatusCode());
    }
}