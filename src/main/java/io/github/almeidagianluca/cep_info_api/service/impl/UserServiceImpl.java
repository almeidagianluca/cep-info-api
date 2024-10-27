package io.github.almeidagianluca.cep_info_api.service.impl;

import io.github.almeidagianluca.cep_info_api.model.CepDetails;
import io.github.almeidagianluca.cep_info_api.model.User;
import io.github.almeidagianluca.cep_info_api.repository.UserRepository;
import io.github.almeidagianluca.cep_info_api.service.CepDetailsService;
import io.github.almeidagianluca.cep_info_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

import static io.github.almeidagianluca.cep_info_api.model.BranchesEnum.hasBranchInCity;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CepDetailsService cepDetailsService;
    @Override
    public ResponseEntity<User> createUser(User user) throws Exception {
        boolean validUser = validateUser(user);
        if (!validUser) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User not allowed: is not from a branch city");
        }
        return ResponseEntity.ok(userRepository.save(user));
    }

    private boolean validateUser(User user) {
        CepDetails cepDetails = cepDetailsService.getCepDetails(user.getCep()).getBody();
        return hasBranchInCity(Objects.requireNonNull(cepDetails).getCidade());
    }
}
