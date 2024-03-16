package com.locadora.service;

import com.locadora.model.locacao.Aluguel;
import com.locadora.model.locacao.Devolucao;

public interface CalculaTempoDecorrido<T extends Number> {

    T calcularTempoDecorrido(Aluguel aluguel, Devolucao devolucao);

}
