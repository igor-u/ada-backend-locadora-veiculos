package com.locadora.repository.impl;

import com.locadora.model.veiculo.Veiculo;
import com.locadora.repository.VeiculoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VeiculoRepositoryInMemoryImpl implements VeiculoRepository {

    private static final VeiculoRepositoryInMemoryImpl instance = new VeiculoRepositoryInMemoryImpl();
    private final List<Veiculo> veiculos = new ArrayList<Veiculo>();

    private VeiculoRepositoryInMemoryImpl() {

    }

    public static VeiculoRepositoryInMemoryImpl getInstance() {
        return instance;
    }

    @Override
    public Veiculo cadastrar(Veiculo veiculo) {
        if (!veiculos.contains(veiculo)) {
            veiculos.add(veiculo);
        }
        return veiculo;
    }

    @Override
    public List<Veiculo> buscarPorParteDoNome(String parteDoNome) {
        return veiculos.stream().filter(v -> v.getNome().contains(parteDoNome)).collect(Collectors.toList());
    }

    @Override
    public Veiculo renomear(Veiculo veiculo, String novoNome) {
        veiculo.setNome(novoNome);
        return veiculo;
    }

    @Override
    public Veiculo alterarIdentificador(Veiculo veiculo, String novoIdentificador) {
        veiculo.setPlaca(novoIdentificador);
        return veiculo;
    }

    @Override
    public void excluir(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

}
