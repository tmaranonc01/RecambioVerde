package com.example.rv3.service;

import com.example.rv3.domain.Pieza;
import com.example.rv3.repository.CocheRepository;
import com.example.rv3.repository.PiezaRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PiezaService extends BaseService<Pieza,Long, PiezaRepository> {

    @Autowired
    private PiezaRepository piezaRepository;
    @Autowired
    private CocheRepository cocheRepository;


    public Page<Pieza> getPiezas(Pageable pageable, @SearchSpec Specification<Pieza> specs){
        return piezaRepository.findAll(specs, pageable);
    }

    public List<Pieza> findPiezaByCoche(Long coche_id){
        return piezaRepository.findPiezaByCoche(coche_id);
    }

    public Pieza addPieza(Pieza nuevaPieza, Long coche_id){
        Pieza pieza = null;
        if(cocheRepository.findById(coche_id).isPresent()){
            pieza = nuevaPieza;
            pieza.setCoche(cocheRepository.findById(coche_id).get());
            pieza = nuevaPieza;
            piezaRepository.save(pieza);
        }
        return pieza;
    }

    public Pieza updateById(Pieza nuevaPieza, Long id){
        Pieza pieza = nuevaPieza;
        if ((piezaRepository.findById(id).isPresent())) {
            pieza.setId(id);
            piezaRepository.save(pieza);
        }
        return pieza;
    }

    @Override
    public void deleteById(Long id) {
        if(findById(id).isPresent()){
            piezaRepository.deleteById(id);
        } else{
            System.out.println("La pieza no existe");
        }
    }



}
