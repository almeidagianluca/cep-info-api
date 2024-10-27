package io.github.almeidagianluca.cep_info_api.controller;

import io.github.almeidagianluca.cep_info_api.model.User;
import org.springframework.http.ResponseEntity;

public interface UserController {
    ResponseEntity<User> createUser(User user) throws Exception;
}
