package com.frete.service;

import com.frete.dao.DistanciaDAO;
import com.frete.model.Distancia;
import com.frete.model.Cidade;
import jakarta.transaction.Transactional;

import java.util.List;

public class DistanciaService {
    private final DistanciaDAO distanciaDAO;

    public DistanciaService(DistanciaDAO distanciaDAO) {
        this.distanciaDAO = distanciaDAO;
    }

    public Double buscarDistanciaEntreCidades(Cidade origem, Cidade destino) {
        return distanciaDAO.findById(origem.getId()).getQuilometragem();
    }
}