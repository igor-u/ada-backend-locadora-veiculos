package com.locadora.service;

import com.locadora.model.locacao.Aluguel;
import com.locadora.model.locacao.Devolucao;

public interface CalculaTempoDecorrido {

    int calcularTempoDecorrido(Aluguel aluguel, Devolucao devolucao);

}
