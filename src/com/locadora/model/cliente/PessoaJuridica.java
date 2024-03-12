package com.locadora.model.cliente;

public class PessoaJuridica implements Cliente {

    private String cnpj;
    private String nome;

    public PessoaJuridica(String cnpj, String nome) {
        super();
        this.cnpj = cnpj;
        this.nome = nome;
    }

    @Override
    public String getIdentificador() {
        return cnpj;
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
