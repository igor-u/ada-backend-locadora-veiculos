package com.locadora.model.cliente;

import java.util.HashMap;
import java.util.Map;

public class PessoaFisica implements Cliente {
	
	private String cpf;
	private String nome;
	
	public PessoaFisica(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}
	
    @Override
    public String toString() {
        return "ClientePF{" +
        		"cpf: " + cpf + ";" +
        		"\n" + "nome: " + nome + "}\n";
    }
	
	@Override
	public Map<TipoIDCliente, String> getIdentificador() {
		Map<TipoIDCliente, String> idComTipo = new HashMap<>();
		idComTipo.put(TipoIDCliente.CPF, cpf);
		return idComTipo;
	}
	@Override
	public void setIdentificador(String id) {
		this.cpf = id;		
	}
	@Override
	public String getNome() {
		return nome;
	}
	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
