package io.github.almeidagianluca.cep_info_api.service;

import io.github.almeidagianluca.cep_info_api.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<User> createUser(User user) throws Exception;
}
