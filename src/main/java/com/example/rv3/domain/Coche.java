package com.example.rv3.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    private String Modelo;
    @NotNull
    private String Motor;
    private int ano;

    @JsonIgnore
    @OneToMany(mappedBy = "coche", fetch = FetchType.LAZY)
    private List<Pieza> piezas;
}
