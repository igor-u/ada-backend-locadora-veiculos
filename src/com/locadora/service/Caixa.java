package com.locadora.service;

import com.locadora.model.locacao.Aluguel;
import com.locadora.model.locacao.Devolucao;

public class Caixa {

    private final CalculaValorDevolucao calculaValorDevolucao;
    private final CalculaTempoDecorrido calculaTempoDecorrido;

    public Caixa(CalculaValorDevolucao calculaValorDevolucao, CalculaTempoDecorrido calculaTempoDecorrido) {
        this.calculaValorDevolucao = calculaValorDevolucao;
        this.calculaTempoDecorrido = calculaTempoDecorrido;
    }

    public double realizarCobranca(Devolucao devolucao) {

        return calculaValorDevolucao.calcularValorDevolucao(
                devolucao.getAluguel().getVeiculoAgregado().getCalculaValorDiaria(),
                calculaTempoDecorrido.calcularTempoDecorrido(devolucao.getAluguel(), devolucao));
    }

}
