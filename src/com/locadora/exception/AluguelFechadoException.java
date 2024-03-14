package com.locadora.exception;

public class AluguelFechadoException extends RuntimeException {

    public AluguelFechadoException(String mensagemErro) {
        super(mensagemErro);
    }

}
