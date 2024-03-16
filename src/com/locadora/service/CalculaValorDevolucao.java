package com.locadora.service;

public interface CalculaValorDevolucao<T extends Number> {

    double calcularValorDevolucao(CalculaValorDiaria calculaValorDiaria, T duracaoAluguel);

}
