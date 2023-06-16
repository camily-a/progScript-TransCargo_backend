package org.fatec.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity( name = "TC_TIPO_CARGA")
public class TipoCarga {

        @Id
        @Column(name = "ID", nullable = false)
        private Integer id;

        @Column(name = "NOME", nullable = false)
        private String nome;

}
