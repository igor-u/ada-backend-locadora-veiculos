package com.locadora.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.locadora.model.veiculo.Veiculo;
import com.locadora.repository.VeiculoRepository;

public class VeiculoRepositoryInMemoryImpl implements VeiculoRepository {

	private final List<Veiculo> veiculos = new ArrayList<Veiculo>();

	private static final VeiculoRepositoryInMemoryImpl instance = new VeiculoRepositoryInMemoryImpl();

	private VeiculoRepositoryInMemoryImpl() {

	}

	public static VeiculoRepositoryInMemoryImpl getInstance(){
		return instance;
	}

	@Override
	public Veiculo cadastrar(Veiculo veiculo) {
		boolean placaExiste = veiculos.stream().anyMatch(v -> v.getPlaca().equals(veiculo.getPlaca()));

		if(!placaExiste) {
			veiculos.add(veiculo);
		}
		return veiculo;
	}

	@Override
	public List<Veiculo> buscarPorParteDoNome(String parteDoNome) {
		return veiculos.stream()
				.filter(v -> v.getNome().toLowerCase().contains(parteDoNome.toLowerCase()))
				.collect(Collectors.toList());
	}

	@Override
	public Veiculo renomear(Veiculo veiculo, String novoNome) {
		veiculo.setNome(novoNome);
		return veiculo;	
	}

	@Override
	public Veiculo alterarIdentificador(Veiculo veiculo, String novoIdentificador) {
		veiculo.setPlaca(novoIdentificador);
		return veiculo;	
	}

	@Override
	public void excluir(Veiculo veiculo) {
		veiculos.remove(veiculo);
	}

}
