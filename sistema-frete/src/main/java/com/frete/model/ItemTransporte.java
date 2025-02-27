package com.frete.model;

import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItemTransporte implements EntidadeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Double peso;
    @ManyToOne
    private Frete frete;

    @Override
    public Long getId() {
        return null;
    }
}