package org.fatec.model.users;

import lombok.Data;
import org.fatec.validator.DocumentConstraint;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TC_USUARIO")
public class Usuario {

    @Id
    @Column(name = "USERNAME", nullable = false)
    @DocumentConstraint
    private String username;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "USER_ROLE", nullable = false)
    private String role;
}