package com.locadora.service;

public class CalculadoraDevolucaoPessoaFisica implements CalculaValorDevolucao<Long> {

    public double calcularValorDevolucao(CalculaValorDiaria calculaValorDiaria, Long dias) {

        double valorCobrado = dias * calculaValorDiaria.calcularValorDiaria();

        if (dias > 5) {
            return valorCobrado * 0.95;
        }

        return valorCobrado;
    }

}
