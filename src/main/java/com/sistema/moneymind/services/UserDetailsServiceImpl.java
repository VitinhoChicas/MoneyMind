package com.sistema.moneymind.services;

import com.sistema.moneymind.domains.Usuario;
import com.sistema.moneymind.repositories.UsuarioRepository;
import com.sistema.moneymind.security.UserSS;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepo;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepo = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<Usuario> user = usuarioRepo.findByEmailUsuario(username);
        if(user.isEmpty()){
            throw  new UsernameNotFoundException("Usuario nao encontrado: " + username);
        }
        return  new UserSS(user.orElse(null));
    }

}