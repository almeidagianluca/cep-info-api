package io.github.almeidagianluca.cep_info_api.repository;

import io.github.almeidagianluca.cep_info_api.model.LogRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRequestRepository extends MongoRepository<LogRequest, String> {
}
