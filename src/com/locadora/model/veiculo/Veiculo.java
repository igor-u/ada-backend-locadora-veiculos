package com.locadora.model.veiculo;

public class Veiculo {

    private String placa;
    private String nome;

    public Veiculo(String placa, String nome) {
        super();
        this.placa = placa;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa: " + placa + ";" +
                "\n" + "modelo: " + nome + "}\n";
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}