package io.github.almeidagianluca.cep_info_api.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
@Builder
public class User {
    private String firstName;
    private String lastName;
    @Id
    private String documentNumber;
    private String cep;
}
