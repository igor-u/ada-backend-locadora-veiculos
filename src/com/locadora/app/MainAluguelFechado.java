package com.locadora.app;

import com.locadora.model.cliente.Cliente;
import com.locadora.model.cliente.PessoaFisica;
import com.locadora.model.locacao.Aluguel;
import com.locadora.model.locacao.Devolucao;
import com.locadora.model.veiculo.Veiculo;
import com.locadora.model.veiculo.VeiculoComValorDiaria;
import com.locadora.service.TipoVeiculo;

import java.time.LocalDate;
import java.time.LocalTime;

public class MainAluguelFechado {

    public static void main(String[] args) {

        Veiculo veiculo1 = new Veiculo("abc-1234", "Vectra");
        VeiculoComValorDiaria vectra = new VeiculoComValorDiaria(veiculo1, TipoVeiculo.MEDIO);
        Cliente pessoaFisica1 = new PessoaFisica("12345", "Joao");

        Aluguel aluguel = new Aluguel.Alugar().veiculo(vectra)
                .paraCliente(pessoaFisica1)
                .noLocal("Local1")
                .naData(LocalDate.of(2024, 03, 12))
                .noHorario(LocalTime.of(12, 30, 0))
                .finalizar();

        Devolucao devolucao = new Devolucao.Devolver().aluguel(aluguel)
                .noLocal("Local2")
                .naData(LocalDate.of(2024, 03, 13))
                .noHorario(LocalTime.of(12, 30, 0))
                .fecharAluguel()
                .finalizar();

        //exception - devolucao sobre aluguel fechado
        try {
            Devolucao devolucao1 = new Devolucao.Devolver().aluguel(aluguel).finalizar();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Continua o programa.");
        }
    }
}