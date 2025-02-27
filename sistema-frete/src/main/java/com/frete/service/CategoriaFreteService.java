package com.frete.service;

import com.frete.dao.CategoriaFreteDAO;
import com.frete.model.CategoriaFrete;
import jakarta.transaction.Transactional;

import java.util.List;


public class CategoriaFreteService {
    private final CategoriaFreteDAO categoriaFreteDAO;

    public CategoriaFreteService(CategoriaFreteDAO categoriaFreteDAO) {
        this.categoriaFreteDAO = categoriaFreteDAO;
    }

    public CategoriaFrete buscarCategoriaFretePorId(Long id) {
        return categoriaFreteDAO.findById(id);
    }
}