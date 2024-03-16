package com.locadora.model.locacao;

import java.time.LocalDate;
import java.time.LocalTime;

import com.locadora.exception.AluguelFechadoException;
import com.locadora.service.CalculaValorDevolucao;
import com.locadora.service.CalculaTempoDecorrido;

public class Devolucao extends EncontroPresencial {

    private Aluguel aluguel;

    private Devolucao() {
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
        aluguel.setPendente(false);
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public static class Devolver {

        private Devolucao devolucao;

        public Devolver aluguel(Aluguel aluguel) throws AluguelFechadoException {
            if (!aluguel.isPendente()) {
                throw new AluguelFechadoException(aluguel.getVeiculoAgregado().getVeiculo().getNome() +
                        " com placa " + aluguel.getVeiculoAgregado().getVeiculo().getPlaca() +
                        " se encontra devoluto.");
            }
            devolucao = new Devolucao();
            devolucao.setAluguel(aluguel);
            return this;
        }

        public Devolver noLocal(String local) {
            devolucao.setLocal(local);
            return this;
        }

        public Devolver naData(LocalDate data) {
            devolucao.setData(data);
            return this;
        }

        public Devolver noHorario(LocalTime horario) {
            devolucao.setHorario(horario);
            return this;
        }

        public Devolver fecharAluguel() {
            devolucao.getAluguel().setPendente(false);
            return this;
        }

        public Devolucao finalizar() {
            return devolucao;
        }
    }

}
