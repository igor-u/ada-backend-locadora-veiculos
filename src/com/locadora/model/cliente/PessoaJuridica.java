package com.locadora.model.cliente;

import java.util.HashMap;
import java.util.Map;

public class PessoaJuridica implements Cliente {
	
	private String cnpj; 
	private String nome;
	
	public PessoaJuridica(String cnpj, String nome) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
	}
	
    @Override
    public String toString() {
        return "ClientePJ{" +
        		"cnpj: " + cnpj + ";" +
        		"\n" + "nome: " + nome + "}\n";
    }
	
	@Override
	public Map<TipoIDCliente, String> getIdentificador() {
		Map<TipoIDCliente, String> idComTipo = new HashMap<>();
		idComTipo.put(TipoIDCliente.CNPJ, cnpj);
		return idComTipo;
	}
	@Override
	public void setIdentificador(String id) {
		this.cnpj = id;	
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
