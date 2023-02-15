package com.example.rv3.service;

import com.example.rv3.domain.Pedido;
import com.example.rv3.repository.PedidoRepository;
import com.example.rv3.repository.UsuarioRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService extends BaseService<Pedido, Long, PedidoRepository> {
    private PedidoRepository pedidoRepository;
    private UsuarioRepository usuarioRepository;


    public Page<Pedido> getPedidos(Pageable pageable, @SearchSpec Specification<Pedido> specs){
        return (Page<Pedido>) pedidoRepository.findAll();
    }

    public Pedido addPedido(Pedido nuevoPedido){
        Pedido pedido = nuevoPedido;
        pedidoRepository.save(pedido);
        return pedido;
    }

    public Pedido updatePedidoById(Pedido nuevoPedido){
        Optional<Pedido> pedido = null;
        try {
            pedido = pedidoRepository.findById(nuevoPedido.getId());
            if (pedido.isPresent()){
                pedidoRepository.save(nuevoPedido);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return pedido.get();
    }

    public List<Pedido> findPedidoByUsuario(Long usuario_id){
        return usuarioRepository.findPedidoByUsuario(usuario_id);
    }

}
