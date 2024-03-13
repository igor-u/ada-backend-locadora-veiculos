package com.locadora.model.veiculo;

import com.locadora.service.CalculaValorDiaria;

public class VeiculoSUV implements CalculaValorDiaria {

	@Override
	public double calcularValorDiaria() {
		return 200;
	}

}
