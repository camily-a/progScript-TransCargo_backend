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
@Table(name = "TC_MOTORISTA")
@PrimaryKeyJoinColumn(name = "tc_pessoa_id")
public class Motorista extends Pessoa {

        @Column(name = "CARTEIRA_MOTORISTA", nullable = false)
        private String carteiraMotorista;

        @Column(name = "VENCIMENTO_CARTA", nullable = false)
        private LocalDateTime vencimentoCarta;

        @Column(name = "TIPO_CARTA", nullable = false)
        private String tipoCarta;

}
