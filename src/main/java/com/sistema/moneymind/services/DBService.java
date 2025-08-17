package com.sistema.moneymind.services;


import com.sistema.moneymind.domains.Banco;
import com.sistema.moneymind.domains.Usuario;
import com.sistema.moneymind.repositories.BancoRepository;
import com.sistema.moneymind.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private UsuarioRepository usRepo;

    @Autowired
    private BancoRepository bancoRepo;

    @Autowired
    private PasswordEncoder encoder;

    public void initDB(){
        Usuario usuario1 = new Usuario(null, "Victor", "victor@gmail.com", encoder.encode("123"), LocalDate.now() );
        Usuario usuario2 = new Usuario(null, "Mateus", "mateus@gmail.com", encoder.encode("123"), LocalDate.now() );

        usRepo.save(usuario1);
        usRepo.save(usuario2);

        Banco banco01 = new Banco(null, "Nu Pagamentos S.A");
        Banco banco02 = new Banco(null, "Banco Santander (Brasil) S.A");

        bancoRepo.save(banco01);
        bancoRepo.save(banco02);

    }







}
