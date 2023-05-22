package org.fatec.login.dto;

import lombok.Data;
import org.fatec.validator.DocumentConstraint;

@Data
public class CadastroDto {

    private String username;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private Boolean notificacoes;
}