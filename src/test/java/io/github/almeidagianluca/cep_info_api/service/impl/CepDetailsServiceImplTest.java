package io.github.almeidagianluca.cep_info_api.service.impl;

import io.github.almeidagianluca.cep_info_api.model.CepDetails;
import io.github.almeidagianluca.cep_info_api.client.CepDetailsClient;
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
class CepDetailsServiceImplTest {

    @InjectMocks
    private CepDetailsServiceImpl cepDetailsService;

    @Mock
    private CepDetailsClient cepDetailsClient;
    @Test
    void getCepDetails() {
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

        when(cepDetailsClient.getCepDetails(cep)).thenReturn(responseEntity);

        // Act
        ResponseEntity<CepDetails> actualResponse = cepDetailsService.getCepDetails(cep);

        // Assert
        verify(cepDetailsClient, times(1)).getCepDetails(cep);
        assertEquals(expectedDetails, actualResponse.getBody());
        assertEquals(OK, actualResponse.getStatusCode());
    }
}