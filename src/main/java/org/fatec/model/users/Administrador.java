package org.fatec.model.users;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TC_ADMINISTRADOR")
@PrimaryKeyJoinColumn(name = "tc_pessoa_id")
public class Administrador extends Pessoa {

        @Column(name = "DATA_NASCIMENTO", nullable = false)
        private LocalDateTime dataNascimento;

        @Column(name = "DATA_ADMISSAO", nullable = false)
        private LocalDateTime dataAdmissao;

        @Column(name = "FUNCAO", nullable = false)
        private String funcao;

}
