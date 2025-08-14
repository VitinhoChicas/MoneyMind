package com.sistema.moneymind.services;


import com.sistema.moneymind.domains.Usuario;
import com.sistema.moneymind.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private UsuarioRepository usRepo;

    public void initDB(){
        Usuario usuario1 = new Usuario(null, "Victor", "victor@gmail", "123", LocalDate.now() );

    usRepo.save(usuario1);


    }







}
