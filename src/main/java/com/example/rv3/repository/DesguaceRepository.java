package com.example.rv3.repository;

import com.example.rv3.domain.Desguace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesguaceRepository extends JpaRepository<Desguace, Long> {
}
