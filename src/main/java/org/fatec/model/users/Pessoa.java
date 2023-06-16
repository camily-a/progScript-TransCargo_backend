package org.fatec.model.users;

import lombok.*;
import org.fatec.validator.DocumentConstraint;

import javax.persistence.*;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

        @Id
        @Column(name = "CPF_CNPJ", nullable = false)
        @DocumentConstraint
        private String cpfCnpj;

        @Column(name = "NOME", nullable = false)
        private String nome;

        @Column(name = "TELEFONE", nullable = false)
        private String telefone;

        @Column(name = "EMAIL", nullable = false)
        private String email;


}
