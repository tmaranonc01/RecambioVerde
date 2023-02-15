package com.example.rv3.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String DNI;
    private String correo;
    private String nombreUsuario;
    private String contrasena;

    @OneToOne(optional = false)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;
}
