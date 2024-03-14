package com.locadora.app;

import java.time.LocalDate;
import java.time.LocalTime;

import com.locadora.model.cliente.Cliente;
import com.locadora.model.cliente.PessoaFisica;
import com.locadora.model.cliente.PessoaJuridica;
import com.locadora.model.locacao.Alugar;
import com.locadora.model.locacao.Devolver;
import com.locadora.model.veiculo.Veiculo;
import com.locadora.model.veiculo.VeiculoComValorDiaria;
import com.locadora.repository.impl.ClienteRepositoryInMemoryImpl;
import com.locadora.repository.impl.VeiculoRepositoryInMemoryImpl;
import com.locadora.service.*;
import com.locadora.model.locacao.Aluguel;
import com.locadora.model.locacao.Devolucao;

public class Main {

    public static void main(String[] args) {

        VeiculoRepositoryInMemoryImpl veiculoRepo = VeiculoRepositoryInMemoryImpl.getInstance();
        Veiculo veiculo1 = new Veiculo("abc-1234", "Vectra");
        Veiculo veiculo2 = new Veiculo("abc-1234", "Celta");
        Veiculo veiculo3 = new Veiculo("bcd-2345", "Duster");

        veiculoRepo.cadastrar(veiculo1);
        veiculoRepo.buscarPorParteDoNome("vectra").forEach((System.out::println));
        veiculoRepo.cadastrar(veiculo2);
        //veiculo2 nao cadastrado - placa repetida
        veiculoRepo.buscarPorParteDoNome("celta").forEach((System.out::println));
        //"Celta" nao encontrado
        veiculoRepo.cadastrar(veiculo3);
        veiculoRepo.buscarPorParteDoNome("duster").forEach((System.out::println));

        VeiculoComValorDiaria vectra = new VeiculoComValorDiaria(veiculo1, TipoVeiculo.MEDIO);
        VeiculoComValorDiaria duster = new VeiculoComValorDiaria(veiculo3, TipoVeiculo.SUV);

        ClienteRepositoryInMemoryImpl clienteRepo = ClienteRepositoryInMemoryImpl.getInstance();
        Cliente pessoaFisica1 = new PessoaFisica("12345", "Joao");
        Cliente pessoaFisica2 = new PessoaFisica("12345", "Paulo");
        Cliente pessoaJuridica1 = new PessoaJuridica("23456", "Nome fantasia");

        clienteRepo.cadastrar(pessoaFisica1);
        clienteRepo.buscarPorParteDoNome("joao").forEach((System.out::println));
        clienteRepo.cadastrar(pessoaFisica2);
        //pessoaFisica2 nao cadastrada - cpf repetido
        clienteRepo.buscarPorParteDoNome("paulo").forEach((System.out::println));
        //"Paulo" nao encontrado
        clienteRepo.cadastrar(pessoaJuridica1);
        clienteRepo.buscarPorParteDoNome("fanta").forEach((System.out::println));

        Aluguel aluguelPF = new Alugar().veiculo(vectra)
                .paraCliente(pessoaFisica1)
                .noLocal("Local1")
                .naData(LocalDate.of(2024, 03, 12))
                .noHorario(LocalTime.of(12, 30, 0))
                .finalizar();

        Devolucao devolucaoPF = new Devolver().aluguel(aluguelPF)
                .noLocal("Local2")
                .naData(LocalDate.of(2024, 03, 18))
                .noHorario(LocalTime.of(12, 30, 0))
                .fecharAluguel()
                .finalizar();

        Caixa caixaPF = new Caixa(new CalculadoraDevolucaoPessoaFisica(), new CalculadoraDiasDecorridos());
        double valorCobradoPF = caixaPF.realizarCobranca(devolucaoPF);
        System.out.println("Valor do primeiro aluguel (PF): " + valorCobradoPF);

		Aluguel aluguelPJ = new Alugar().veiculo(duster)
				.paraCliente(pessoaJuridica1)
				.noLocal("Local3")
				.naData(LocalDate.of(2024, 03, 12))
				.noHorario(LocalTime.of(12, 30, 0))
				.finalizar();

		Devolucao devolucaoPJ = new Devolver().aluguel(aluguelPJ)
				.noLocal("Local4")
				.naData(LocalDate.of(2024, 03, 16))
				.noHorario(LocalTime.of(12, 30, 0))
				.fecharAluguel()
				.finalizar();

		Caixa caixaPJ = new Caixa(new CalculadoraDevolucaoPessoaJuridica(), new CalculadoraDiasDecorridos());
		double valorCobradoPJ = caixaPJ.realizarCobranca(devolucaoPJ);
		System.out.println("Valor do segundo aluguel (PJ): " + valorCobradoPJ);

    }

}


