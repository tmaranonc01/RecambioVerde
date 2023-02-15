package com.example.rv3.repository;

import com.example.rv3.domain.Pieza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PiezaRepository extends JpaRepository<Pieza,Long> {

    @Query("select p from Pieza p where p.coche_id= :id")
    List<Pieza> findPiezaByCoche(Long id);
}
