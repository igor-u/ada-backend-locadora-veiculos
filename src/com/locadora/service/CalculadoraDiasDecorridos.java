package com.locadora.service;

import com.locadora.model.locacao.Aluguel;
import com.locadora.model.locacao.Devolucao;

import java.time.temporal.ChronoUnit;

public class CalculadoraDiasDecorridos implements CalculaTempoDecorrido {

	@Override
	public int calcularTempoDecorrido(Aluguel aluguel, Devolucao devolucao) {
		
		int diasDecorridos = 1 + (int) ChronoUnit.DAYS.between(aluguel.getData(), devolucao.getData());
		
		if(aluguel.getHorario().compareTo(devolucao.getHorario()) >= 0) {
			diasDecorridos--;
		}

		return diasDecorridos;
	}

}
