package com.frete.model;

import jakarta.persistence.*;

@Entity
public class Frete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Cidade cidadeOrigem;

    @ManyToOne
    private Cidade cidadeDestino;

    @ManyToOne
    private CategoriaFrete categoriaFrete;

    private double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cidade getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(Cidade cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public Cidade getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(Cidade cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public CategoriaFrete getCategoriaFrete() {
        return categoriaFrete;
    }

    public void setCategoriaFrete(CategoriaFrete categoriaFrete) {
        this.categoriaFrete = categoriaFrete;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // Getters e Setters
}
