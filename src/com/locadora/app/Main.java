package com.locadora.app;

import java.time.LocalDate;
import java.time.LocalTime;

import com.locadora.model.cliente.Cliente;
import com.locadora.model.cliente.PessoaFisica;
import com.locadora.model.cliente.PessoaJuridica;
import com.locadora.model.veiculo.Veiculo;
import com.locadora.model.veiculo.VeiculoComValorDiaria;
import com.locadora.model.veiculo.VeiculoMedio;
import com.locadora.repository.impl.ClienteRepositoryInMemoryImpl;
import com.locadora.repository.impl.VeiculoRepositoryInMemoryImpl;
import com.locadora.service.CalculadoraDevolucaoPessoaFisica;
import com.locadora.service.locacao.Aluguel;
import com.locadora.service.locacao.CalculadoraDiasDecorridos;
import com.locadora.service.locacao.Devolucao;

public class Main {

	public static void main(String[] args) {
		
		Veiculo veiculo = new Veiculo("abc-1234", "Vectra");
		Veiculo veiculo2 = new Veiculo("abc-1234", "Vectra");
		
		VeiculoComValorDiaria veiculoComValorDiaria = new VeiculoComValorDiaria(veiculo, new VeiculoMedio());
		
		Cliente pessoaFisica = new PessoaFisica("12345", "Joao");
		Cliente pessoaFisica2 = new PessoaFisica("12345", "Joao");
		Cliente pessoaJuridica = new PessoaJuridica("12345", "Joao");
		
		Aluguel aluguel = new Aluguel(veiculoComValorDiaria, pessoaFisica,
				"Local1", LocalDate.of(2024, 03, 12), LocalTime.of(12, 30, 0));
		
		Devolucao devolucao = new Devolucao(aluguel, "Local2", LocalDate.of(2024, 03, 13), LocalTime.of(12, 31, 0));
		double valorCobrado = devolucao.realizarCobranca(new CalculadoraDevolucaoPessoaFisica(), new CalculadoraDiasDecorridos());
		
		System.out.println(valorCobrado);
		
		VeiculoRepositoryInMemoryImpl veiculoRepo = VeiculoRepositoryInMemoryImpl.getInstance();
		ClienteRepositoryInMemoryImpl clienteRepo = ClienteRepositoryInMemoryImpl.getInstance();
		
		veiculoRepo.cadastrar(veiculo);
		veiculoRepo.cadastrar(veiculo2);
		
		clienteRepo.cadastrar(pessoaFisica);
		clienteRepo.cadastrar(pessoaFisica2);
		clienteRepo.cadastrar(pessoaJuridica);
		
		veiculoRepo.buscarPorParteDoNome("Vectra").forEach((System.out::println));
		
		clienteRepo.buscarPorParteDoNome("Joao").forEach((System.out::println));
	}

}
