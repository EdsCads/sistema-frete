package com.frete.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Veiculo implements EntidadeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String placa;

    @ManyToOne
    private TipoVeiculo tipoVeiculo;

    @ManyToOne
    private Filial filial;

    @Override
    public Long getId() {
        return id;
    }
}
