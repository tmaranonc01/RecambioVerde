package com.example.rv3.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Pieza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    private String nombre;
    private String descripcion;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "coche_id", referencedColumnName = "id")
    private Coche coche;
}
