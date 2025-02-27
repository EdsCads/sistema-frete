package com.frete.dao;

import com.frete.model.Funcionario;

public class FuncionarioDAO extends GenericDAO<Funcionario> {
    public FuncionarioDAO() {
        super(Funcionario.class);
    }
}