package com.locadora.service.locacao;

import java.time.LocalDate;
import java.time.LocalTime;

import com.locadora.service.CalculaValorDevolucao;

public class Devolucao extends EncontroPresencial {
	
	private final Aluguel aluguel;
	
	public Devolucao(Aluguel aluguel, String local, LocalDate data, LocalTime horario) {
		super(local, data, horario);
		this.aluguel = aluguel;
		aluguel.getVeiculoAgregado().setDisponivel(true);
	}
	
	public double realizarCobranca(CalculaValorDevolucao calculaValorDevolucao, CalculaTempoDecorrido calculaTempoDecorrido) {
		
		return calculaValorDevolucao.calcularValorDevolucao(
				aluguel.getVeiculoAgregado().getCalculaValorDiaria(),
				calculaTempoDecorrido.calcularTempoDecorrido(aluguel, this));
			
	}

}
