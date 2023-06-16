package org.fatec.model.users;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TC_CLIENTE")
@PrimaryKeyJoinColumn(name = "tc_pessoa_id")
public class Cliente extends Pessoa {

        @Column(name = "PERMITE_NOTIFICACOES", nullable = false)
        private Boolean permiteNotificacoes;

}
