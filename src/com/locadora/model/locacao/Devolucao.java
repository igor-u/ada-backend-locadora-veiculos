package com.locadora.model.locacao;

import java.time.LocalDate;
import java.time.LocalTime;

import com.locadora.exception.AluguelFechadoException;
import com.locadora.service.CalculaValorDevolucao;
import com.locadora.service.CalculaTempoDecorrido;

public class Devolucao extends EncontroPresencial {

	private Aluguel aluguel;

	public void setAluguel(Aluguel aluguel) throws AluguelFechadoException {
		if (!aluguel.isPendente()){
			throw new AluguelFechadoException(aluguel.getVeiculoAgregado().getVeiculo().getNome() +
					" com placa "+ aluguel.getVeiculoAgregado().getVeiculo().getPlaca() +
					" se encontra devoluto.");
		}
		this.aluguel = aluguel;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

}
