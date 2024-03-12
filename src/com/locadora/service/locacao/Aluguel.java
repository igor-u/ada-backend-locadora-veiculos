package com.locadora.service.locacao;

import com.locadora.model.cliente.Cliente;
import com.locadora.model.veiculo.VeiculoComValorDiaria;

import java.time.LocalDate;
import java.time.LocalTime;

public class Aluguel extends EncontroPresencial {

    private VeiculoComValorDiaria veiculoComValorDiaria;
    private Cliente cliente;
    private boolean pendente;

    public Aluguel(VeiculoComValorDiaria veiculoComValorDiaria, Cliente cliente, String local, LocalDate data, LocalTime horario) {
        super(local, data, horario);
        this.veiculoComValorDiaria = veiculoComValorDiaria;
        veiculoComValorDiaria.setDisponivel(false);
        this.cliente = cliente;
        this.pendente = false;
    }

    public VeiculoComValorDiaria getVeiculoAgregado() {
        return veiculoComValorDiaria;
    }

    public void setVeiculoAgregado(VeiculoComValorDiaria veiculoAgregado) {
        this.veiculoComValorDiaria = veiculoAgregado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isPendente() {
        return pendente;
    }

    public void setPendente(boolean pendente) {
        this.pendente = pendente;
    }

}
