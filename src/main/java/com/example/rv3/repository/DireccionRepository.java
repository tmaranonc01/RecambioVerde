package com.example.rv3.repository;

import com.example.rv3.domain.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
    Direccion findDireccionById(Long id);

}
