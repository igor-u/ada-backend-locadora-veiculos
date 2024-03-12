package com.locadora.model.cliente;

public class PessoaFisica implements Cliente {

    private String cpf;
    private String nome;

    public PessoaFisica(String cpf, String nome) {
        super();
        this.cpf = cpf;
        this.nome = nome;
    }

    @Override
    public String getIdentificador() {
        return cpf;
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
