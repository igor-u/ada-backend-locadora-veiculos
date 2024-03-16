package com.locadora.service;

public class CalculadoraDevolucaoPessoaJuridica implements CalculaValorDevolucao<Long> {

    public double calcularValorDevolucao(CalculaValorDiaria calculaValorDiaria, Long dias) {

        double valorCobrado = dias * calculaValorDiaria.calcularValorDiaria();

        if (dias > 3) {
            return valorCobrado * 0.90;
        }

        return valorCobrado;
    }

}
