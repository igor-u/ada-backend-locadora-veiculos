package com.locadora.service;

public class CalculadoraDevolucaoPessoaJuridica implements CalculaValorDevolucao {

	public double calcularValorDevolucao(CalculaValorDiaria calculaValorDiaria, int dias) {

		double valorCobrado = dias * calculaValorDiaria.calcularValorDiaria();

		if (dias > 3) {
			return valorCobrado*0.90;
		}

		return valorCobrado;
	}

}
