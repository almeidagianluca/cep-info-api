package io.github.almeidagianluca.cep_info_api.service.impl;

import io.github.almeidagianluca.cep_info_api.model.CepDetails;
import io.github.almeidagianluca.cep_info_api.model.User;
import io.github.almeidagianluca.cep_info_api.repository.UserRepository;
import io.github.almeidagianluca.cep_info_api.service.CepDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private CepDetailsService cepDetailsService;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void createUserFromBranchCity() throws Exception {
        // Arrange
        User user = User.builder().cep("01001000").build();
        CepDetails cepDetails = CepDetails.builder().city("São Paulo").build();
        when(cepDetailsService.getCepDetails("01001000")).thenReturn(ResponseEntity.ok(cepDetails));
        when(userRepository.save(user)).thenReturn(user);

        // Act
        ResponseEntity<User> response = userService.createUser(user);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void createUserOutOfBranchCity() {
        // Arrange
        User user = User.builder().cep("80010000").build();
        CepDetails cepDetails = CepDetails.builder().city("Curitiba").build();
        when(cepDetailsService.getCepDetails("80010000")).thenReturn(ResponseEntity.ok(cepDetails));

        // Act, Assert
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> userService.createUser(user));
        assertEquals(HttpStatus.FORBIDDEN, exception.getStatusCode());
        assertEquals("User not allowed: is not from a branch city", exception.getReason());
        verify(userRepository, never()).save(any(User.class));
    }
}