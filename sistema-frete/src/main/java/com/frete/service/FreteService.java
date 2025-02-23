package com.frete.service;

import com.frete.dao.GenericDAO;
import com.frete.model.Frete;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

public class FreteService {
    private GenericDAO<Frete> freteDAO;

    public FreteService(EntityManager entityManager) {
        this.freteDAO = new GenericDAO<>(entityManager, Frete.class);
    }

    public void registrarFrete(Frete frete) {
        double valorFrete = calcularValorFrete(frete);
        frete.setValor(valorFrete);
        freteDAO.salvar(frete);
    }

    private double calcularValorFrete(Frete frete) {
        double valorPorKm = 5.0;
        double percentual = frete.getCategoriaFrete().getPercentual();
        return 100 * valorPorKm * (1 + percentual / 100);
    }

    public List<Frete> listarFretesPorCliente(Long clienteId) {
        return freteDAO.listarTodos().stream()
                .filter(f -> f.getCliente().getId().equals(clienteId))
                .collect(Collectors.toList());
    }

    public Frete buscarFretePorId(Long id) {
        return freteDAO.buscarPorId(id);
    }
}
