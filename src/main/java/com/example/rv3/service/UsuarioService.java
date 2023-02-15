package com.example.rv3.service;

import com.example.rv3.domain.Usuario;
import com.example.rv3.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService extends BaseService<Usuario, Long, UsuarioRepository> {
    private UsuarioRepository usuarioRepository;

    public Usuario addUsuario(Usuario nuevoUsuario){
        Usuario usuario = nuevoUsuario;
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Usuario updateUsuarioById(Usuario nuevoUsuario){
        Optional<Usuario> usuario = null;
        try {
            usuario = usuarioRepository.findById(nuevoUsuario.getId());
            if (usuario.isPresent()){
                usuarioRepository.save(nuevoUsuario);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return usuario.get();
    }

    public Usuario findUsuario(Long id){
        Usuario usuario = usuarioRepository.findUsuarioById(id);
        return usuario;
    }
}
