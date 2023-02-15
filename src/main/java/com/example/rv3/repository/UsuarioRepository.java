package com.example.rv3.repository;

import com.example.rv3.domain.Pedido;
import com.example.rv3.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioById(Long id);

    List<Pedido> findPedidoByUsuario(Long usuario_id);

    Optional<Object> findUsuarioByNombreUsuario(String username);
}
