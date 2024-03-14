package com.locadora.model.locacao;

import java.time.LocalDate;
import java.time.LocalTime;

public class Devolver {

    private Devolucao devolucao = new Devolucao();

    public Devolver aluguel(Aluguel aluguel) {
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

    public Devolver fecharAluguel(){
        devolucao.getAluguel().setPendente(false);
        return this;
    }

    public Devolucao finalizar(){
        return devolucao;
    }
}
