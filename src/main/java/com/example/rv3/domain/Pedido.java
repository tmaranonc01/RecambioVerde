package com.example.rv3.domain;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private double total;
    private String origen;
    private String destino;

    @ManyToMany(mappedBy = "pedidos")
    private List<Desguace> desguaces;
}
