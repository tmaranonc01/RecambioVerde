package com.example.rv3.service;

import com.example.rv3.domain.Direccion;
import com.example.rv3.repository.DireccionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DireccionService extends BaseService<Direccion, Long, DireccionRepository> {
    private final DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }


    public Direccion addDireccion(Direccion nuevaDireccion){
        Direccion direccion = nuevaDireccion;
        direccionRepository.save(direccion);
        return direccion;
    }

    public Direccion updateDireccionById(Direccion nuevaDireccion){
        Optional<Direccion> direccion = null;
        try {
            direccion = direccionRepository.findById(nuevaDireccion.getId());
            if (direccion.isPresent()){
                direccionRepository.save(nuevaDireccion);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return direccion.get();
    }

    public Direccion findDireccion(Long id){
        Direccion direccion = direccionRepository.findDireccionById(id);
        return direccion;
    }
}
