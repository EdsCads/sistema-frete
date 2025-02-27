package com.frete.service;

import com.frete.dao.*;
import com.frete.model.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreteService {

    private final FreteDAO freteDAO;
    private final DistanciaDAO distanciaDAO;
    private final CategoriaFreteDAO categoriaFreteDAO;

    public FreteService(FreteDAO freteDAO, DistanciaDAO distanciaDAO, CategoriaFreteDAO categoriaFreteDAO) {
        this.freteDAO = freteDAO;
        this.distanciaDAO = distanciaDAO;
        this.categoriaFreteDAO = categoriaFreteDAO;
    }

    @Transactional
    public Frete registrarFrete(Frete frete) {
        // Calcula o valor do frete
        Distancia distancia = distanciaDAO.findById(frete.getOrigem().getId());
        CategoriaFrete categoriaFrete = categoriaFreteDAO.findById(frete.getCategoriaFrete().getId());

        Double valorFrete = distancia.getQuilometragem() * 1.5 * (1 + categoriaFrete.getPercentual() / 100);
        frete.setValor(valorFrete);

        // Salva o frete no banco de dados
        return freteDAO.save(frete);
    }

    public List<Frete> listarFretesPorCliente(Cliente cliente) {
        return freteDAO.buscarPorCliente(cliente);
    }

    public Frete buscarFretePorId(Long id) {
        return freteDAO.findById(id);
    }
}