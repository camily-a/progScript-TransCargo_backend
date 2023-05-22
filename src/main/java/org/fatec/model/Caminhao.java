package org.fatec.model;

import lombok.*;

import javax.persistence.*;
import java.time.Year;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity( name = "TC_CAMINHAO")
public class Caminhao {

        @Id
        @Column(name = "PLACA", nullable = false)
        private String placa;

        @Column(name = "MODELO", nullable = false)
        private String modelo;

        @Column(name = "ANO_FABRICACAO", nullable = false)
        private String anoFabricacao;

        @Column(name = "CARGA_MAXIMA", nullable = false)
        private Integer cargaMaxima;

        @Column(name = "ALTURA")
        private Double altura;

        @Column(name = "QTD_EIXOS")
        private Integer qtdEixos;

        @Column(name = "TIPO_CARROCERIA")
        private String tipoCarroceria;

}
