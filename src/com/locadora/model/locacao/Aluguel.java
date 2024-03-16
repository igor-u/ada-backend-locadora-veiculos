package com.locadora.model.locacao;

import java.time.LocalDate;
import java.time.LocalTime;

import com.locadora.exception.VeiculoIndisponivelException;
import com.locadora.model.cliente.Cliente;
import com.locadora.model.veiculo.VeiculoComValorDiaria;

public class Aluguel extends EncontroPresencial {

    private VeiculoComValorDiaria veiculoComValorDiaria;
    private Cliente cliente;
    private boolean pendente = true;

    private Aluguel() {
    }

    public VeiculoComValorDiaria getVeiculoAgregado() {
        return veiculoComValorDiaria;
    }

    public void setVeiculoAgregado(VeiculoComValorDiaria veiculoAgregado) {
        this.veiculoComValorDiaria = veiculoAgregado;
        veiculoAgregado.setDisponivel(false);
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

    public static class Alugar {

        private Aluguel aluguel;

        public Alugar veiculo(VeiculoComValorDiaria veiculo) throws VeiculoIndisponivelException {
            if (!veiculo.isDisponivel()) {
                throw new VeiculoIndisponivelException(veiculo.getVeiculo().getNome() +
                        " com placa " + veiculo.getVeiculo().getPlaca() +
                        " se encontra alugado.");
            }
            aluguel = new Aluguel();
            aluguel.setVeiculoAgregado(veiculo);
            return this;
        }

        public Alugar paraCliente(Cliente cliente) {
            aluguel.setCliente(cliente);
            return this;
        }

        public Alugar noLocal(String local) {
            aluguel.setLocal(local);
            return this;
        }

        public Alugar naData(LocalDate data) {
            aluguel.setData(data);
            return this;
        }

        public Alugar noHorario(LocalTime horario) {
            aluguel.setHorario(horario);
            return this;
        }

        public Aluguel finalizar() {
            return aluguel;
        }

    }

}


