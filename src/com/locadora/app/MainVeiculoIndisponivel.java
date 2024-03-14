package com.locadora.app;

import com.locadora.model.cliente.Cliente;
import com.locadora.model.cliente.PessoaFisica;
import com.locadora.model.locacao.Alugar;
import com.locadora.model.locacao.Aluguel;
import com.locadora.model.veiculo.Veiculo;
import com.locadora.model.veiculo.VeiculoComValorDiaria;
import com.locadora.service.TipoVeiculo;

import java.time.LocalDate;
import java.time.LocalTime;

public class MainVeiculoIndisponivel {

    public static void main(String[] args) {

        Veiculo veiculo1 = new Veiculo("abc-1234", "Vectra");
        VeiculoComValorDiaria vectra = new VeiculoComValorDiaria(veiculo1, TipoVeiculo.MEDIO);
        Cliente pessoaFisica1 = new PessoaFisica("12345", "Joao");

        Aluguel aluguel = new Alugar().veiculo(vectra)
                .paraCliente(pessoaFisica1)
                .noLocal("Local1")
                .naData(LocalDate.of(2024, 03, 12))
                .noHorario(LocalTime.of(12, 30, 0))
                .finalizar();

        //exception - veiculo indisponivel
        try {
            Aluguel aluguel1 = new Alugar().veiculo(vectra).finalizar();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

}
