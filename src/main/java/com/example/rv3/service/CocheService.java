package com.example.rv3.service;

import com.example.rv3.domain.Coche;
import com.example.rv3.domain.Pieza;
import com.example.rv3.repository.CocheRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocheService extends BaseService<Coche,Long, CocheRepository> {
    CocheRepository cocheRepository;

    public Page<Coche> getCoches(Pageable pageable, @SearchSpec Specification<Coche> specs){
        return cocheRepository.findAll(pageable, specs);
    }

    public List<Pieza> findAllPiezas(Long coche_id){
        List<Pieza> piezas = null;
        Optional<Coche> coche = cocheRepository.findById(coche_id);
        if (coche.isPresent()){
            piezas = coche.get().getPiezas();
        }
        return piezas;
    }

    public Coche addCoche(Coche nuevoCoche){
        Coche coche = nuevoCoche;
        cocheRepository.save(coche);
        return coche;
    }

    public Coche updateCocheById(Coche nuevoCoche){
        Optional<Coche> coche = null;
        try {
            coche = cocheRepository.findById(nuevoCoche.getId());
            if(coche.isPresent()){
                cocheRepository.save(nuevoCoche);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return coche.get();
    }

    @Override
    public void deleteById(Long id) {
        if(findById(id).isPresent()){
            cocheRepository.deleteById(id);
        } else {
            System.out.println("El coche no existe");
        }
    }
}
