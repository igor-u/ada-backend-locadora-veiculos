package com.locadora.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.locadora.model.cliente.Cliente;
import com.locadora.repository.ClienteRepository;

public class ClienteRepositoryInMemoryImpl implements ClienteRepository {

	private final List<Cliente> clientes = new ArrayList<Cliente>();

	private static final ClienteRepositoryInMemoryImpl instance = new ClienteRepositoryInMemoryImpl();

	private ClienteRepositoryInMemoryImpl() {

	}

	public static ClienteRepositoryInMemoryImpl getInstance(){
		return instance;
	}

	@Override
	public Cliente cadastrar(Cliente cliente) {
		boolean idExiste = clientes.stream().anyMatch(v -> v.getIdentificador().equals(cliente.getIdentificador()));

		if(!idExiste) {
			clientes.add(cliente);
		}
		return cliente;

	}

	@Override
	public List<Cliente> buscarPorParteDoNome(String parteDoNome) {
		return clientes.stream().filter(c -> c.getNome().contains(parteDoNome)).collect(Collectors.toList());

	}

	@Override
	public Cliente renomear(Cliente cliente, String novoNome) {
		cliente.setNome(novoNome);
		return cliente;

	}
	
	@Override
	public Cliente alterarIdentificador(Cliente cliente, String novoIdentificador) {
		cliente.setIdentificador(novoIdentificador);
		return cliente;
	}

	@Override
	public void excluir(Cliente cliente) {
		clientes.remove(cliente);	

	}

}


