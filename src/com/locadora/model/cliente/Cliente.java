package com.locadora.model.cliente;

import java.util.Map;

public interface Cliente {

    Map<TipoIDCliente, String> getIdentificador();

    void setIdentificador(String id);

    String getNome();

    void setNome(String nome);

}
