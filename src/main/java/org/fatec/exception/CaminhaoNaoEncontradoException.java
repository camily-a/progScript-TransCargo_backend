package org.fatec.exception;

public class CaminhaoNaoEncontradoException extends RuntimeException {
    public CaminhaoNaoEncontradoException() {
        super("Caminhao não encontrado.");
    }

}
