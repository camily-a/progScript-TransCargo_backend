package org.fatec.model;

import lombok.*;
import org.fatec.validator.DocumentConstraint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Year;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity( name = "TC_PESSOA")
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
