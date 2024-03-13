package com.locadora.model.veiculo;

import com.locadora.service.CalculaValorDiaria;

public class VeiculoPequeno implements CalculaValorDiaria {

	@Override
	public double calcularValorDiaria() {
		return 100;
	}

}
