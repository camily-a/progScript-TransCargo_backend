package org.fatec.login.dto;

import lombok.Data;
import org.fatec.validator.DocumentConstraint;

import java.time.LocalDateTime;

@Data
public class CadastroDto {

    @DocumentConstraint
    private String username;
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    private Boolean notificacoes;

    private LocalDateTime dataNascimento;
    private LocalDateTime dataAdmissao;
    private String funcao;

    private String carteiraMotorista;
    private LocalDateTime vencimentoCarta;
    private String tipoCarta;

}