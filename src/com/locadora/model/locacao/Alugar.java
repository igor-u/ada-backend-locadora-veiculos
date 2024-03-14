package com.locadora.model.locacao;

import com.locadora.model.cliente.Cliente;
import com.locadora.model.veiculo.VeiculoComValorDiaria;

import java.time.LocalDate;
import java.time.LocalTime;

public class Alugar {

    private Aluguel aluguel = new Aluguel();

    public Alugar veiculo(VeiculoComValorDiaria veiculo) {
        aluguel.setVeiculoAgregado(veiculo);
        return this;
    }

    public Alugar paraCliente(Cliente cliente) {
        aluguel.setCliente(cliente);
        return this;
    }

    public Alugar noLocal(String local) {
        aluguel.setLocal(local);
        return this;
    }

    public Alugar naData(LocalDate data) {
        aluguel.setData(data);
        return this;
    }

    public Alugar noHorario(LocalTime horario) {
        aluguel.setHorario(horario);
        return this;
    }

    public Aluguel finalizar(){
        return aluguel;
    }

}
