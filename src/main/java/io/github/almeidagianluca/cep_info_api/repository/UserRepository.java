package io.github.almeidagianluca.cep_info_api.repository;

import io.github.almeidagianluca.cep_info_api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
