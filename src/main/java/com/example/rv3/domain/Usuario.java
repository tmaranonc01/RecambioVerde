package com.example.rv3.domain;

import javax.persistence.*;
import lombok.*;

import java.util.Collection;

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

    public Collection<Object> getRoles() {
        return null;
    }
}
