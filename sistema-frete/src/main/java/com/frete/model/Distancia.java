package com.frete.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Distancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cidade origem;

    @ManyToOne
    private Cidade destino;

    private Double quilometragem; // Certifique-se de que o campo existe

    // Getters e Setters (gerados pelo Lombok)
}