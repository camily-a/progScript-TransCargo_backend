package org.fatec.model;

import lombok.*;
import org.fatec.validator.DocumentConstraint;

import javax.persistence.*;
import java.time.Year;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TC_CLIENTE")
public class Cliente extends Pessoa {

        @Column(name = "PERMITE_NOTIFICACOES", nullable = false)
        private Boolean permiteNotificacoes;

}
