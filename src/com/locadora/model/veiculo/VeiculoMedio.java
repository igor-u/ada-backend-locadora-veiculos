package com.locadora.model.veiculo;

import com.locadora.service.CalculaValorDiaria;

public class VeiculoMedio implements CalculaValorDiaria {

    @Override
    public double calcularValorDiaria() {
        return 150;
    }

}
