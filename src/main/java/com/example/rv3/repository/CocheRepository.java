package com.example.rv3.repository;

import com.example.rv3.domain.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface CocheRepository extends JpaRepository<Coche, Long>, JpaSpecificationExecutor<Coche> {

}
