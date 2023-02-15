package com.example.rv3.service;

import com.example.rv3.domain.Desguace;
import com.example.rv3.domain.Pedido;
import com.example.rv3.repository.DesguaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesguaceService extends BaseService<Desguace, Long, DesguaceRepository> {
    private DesguaceRepository desguaceRepository;

    public Desguace addDesguace(Desguace nuevoDesguace){
        Desguace desguace = nuevoDesguace;
        desguaceRepository.save(desguace);
        return desguace;
    }

    public List<Pedido> findAllPedidos(Long desguace_id){
        List<Pedido> pedidos = null;
        Optional<Desguace> desguace = desguaceRepository.findById(desguace_id);
        if (desguace.isPresent()){
            pedidos = desguace.get().getPedidos();
        }
        return  pedidos;
    }
}
