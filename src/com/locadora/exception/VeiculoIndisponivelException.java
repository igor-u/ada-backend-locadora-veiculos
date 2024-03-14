package com.locadora.exception;

public class VeiculoIndisponivelException extends RuntimeException {

    public VeiculoIndisponivelException(String mensagemErro) {
        super(mensagemErro);
    }

}
