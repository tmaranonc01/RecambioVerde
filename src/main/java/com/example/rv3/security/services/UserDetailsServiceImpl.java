package com.example.rv3.security.services;

import com.example.rv3.domain.Usuario;
import com.example.rv3.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        Usuario user = (Usuario) usuarioRepository.findUsuarioByNombreUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return null /*UserDetailsImpl.build(user)*/;
    }
}
