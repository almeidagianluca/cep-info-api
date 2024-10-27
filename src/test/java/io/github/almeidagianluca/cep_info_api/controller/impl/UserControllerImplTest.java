package io.github.almeidagianluca.cep_info_api.controller.impl;

import io.github.almeidagianluca.cep_info_api.model.User;
import io.github.almeidagianluca.cep_info_api.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerImplTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserControllerImpl userController;

    @Test
    void createUser() throws Exception {
        // Arrange
        User user = User.builder().build();
        ResponseEntity<User> expectedResponse = new ResponseEntity<>(user, HttpStatus.OK);
        when(userService.createUser(user)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<User> response = userController.createUser(user);

        // Assert
        assertEquals(expectedResponse, response);
        verify(userService, times(1)).createUser(user);
    }
}