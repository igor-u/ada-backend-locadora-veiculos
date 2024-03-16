package com.locadora.service;

import com.locadora.model.locacao.Aluguel;
import com.locadora.model.locacao.Devolucao;

import java.time.temporal.ChronoUnit;

public class CalculadoraDiasDecorridos implements CalculaTempoDecorrido<Long> {

    @Override
    public Long calcularTempoDecorrido(Aluguel aluguel, Devolucao devolucao) {

        Long diasDecorridos = 1 + ChronoUnit.DAYS.between(aluguel.getData(), devolucao.getData());

        if (aluguel.getHorario().compareTo(devolucao.getHorario()) >= 0) {
            diasDecorridos--;
        }

        return diasDecorridos;
    }

}
