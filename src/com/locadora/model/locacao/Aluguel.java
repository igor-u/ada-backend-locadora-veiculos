package com.locadora.model.locacao;

import java.time.LocalDate;
import java.time.LocalTime;

import com.locadora.exception.VeiculoIndisponivelException;
import com.locadora.model.cliente.Cliente;
import com.locadora.model.veiculo.VeiculoComValorDiaria;

public class Aluguel extends EncontroPresencial {

	private VeiculoComValorDiaria veiculoComValorDiaria;
	private Cliente cliente;
	private boolean pendente = true;

	public VeiculoComValorDiaria getVeiculoAgregado() {
		return veiculoComValorDiaria;
	}

	public void setVeiculoAgregado(VeiculoComValorDiaria veiculoAgregado) throws VeiculoIndisponivelException {
		if(!veiculoAgregado.isDisponivel()) {
			throw new VeiculoIndisponivelException(veiculoAgregado.getVeiculo().getNome() +
					" com placa " +	veiculoAgregado.getVeiculo().getPlaca() +
					" se encontra alugado.");
		}
		this.veiculoComValorDiaria = veiculoAgregado;
		veiculoAgregado.setDisponivel(false);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isPendente() {
		return pendente;
	}

	public void setPendente(boolean pendente) {
		this.pendente = pendente;
	}
	
}
