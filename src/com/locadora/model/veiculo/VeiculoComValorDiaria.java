package com.locadora.model.veiculo;

import com.locadora.service.CalculaValorDiaria;

public class VeiculoComValorDiaria {
	
	private Veiculo veiculo;
	private boolean disponivel;
	
	private CalculaValorDiaria calculaValorDiaria;

	public VeiculoComValorDiaria(Veiculo veiculo, CalculaValorDiaria calculaValorDiaria) {
		this.veiculo = veiculo;
		this.calculaValorDiaria = calculaValorDiaria;
		this.disponivel = true;
	}
	
	public double calcularValorDiaria() {
		return calculaValorDiaria.calcularValorDiaria();
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public CalculaValorDiaria getCalculaValorDiaria() {
		return calculaValorDiaria;
	}

	public void setCalculaValorDiaria(CalculaValorDiaria calculaValorDiaria) {
		this.calculaValorDiaria = calculaValorDiaria;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

}
