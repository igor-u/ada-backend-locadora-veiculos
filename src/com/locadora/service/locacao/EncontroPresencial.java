package com.locadora.service.locacao;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class EncontroPresencial {

    private String local;
    private LocalDate data;
    private LocalTime horario;

    public EncontroPresencial(String local, LocalDate data, LocalTime horario) {
        this.local = local;
        this.data = data;
        this.horario = horario;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }


}
