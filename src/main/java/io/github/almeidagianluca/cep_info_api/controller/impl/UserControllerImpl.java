package io.github.almeidagianluca.cep_info_api.controller.impl;

import io.github.almeidagianluca.cep_info_api.controller.UserController;
import io.github.almeidagianluca.cep_info_api.model.User;
import io.github.almeidagianluca.cep_info_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {
    @Autowired
    UserService userService;
    @Override
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
        return userService.createUser(user);
    }
}
