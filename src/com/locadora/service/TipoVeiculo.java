package com.locadora.service;

public enum TipoVeiculo implements CalculaValorDiaria {

    PEQUENO {
        @Override
        public double calcularValorDiaria() {
            return 100;
        }
    },

    MEDIO {
        @Override
        public double calcularValorDiaria() {
            return 150;
        }
    },

    SUV {
        @Override
        public double calcularValorDiaria() {
            return 200;
        }
    }

}
