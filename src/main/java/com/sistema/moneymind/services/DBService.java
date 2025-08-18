package com.sistema.moneymind.services;


import com.sistema.moneymind.domains.Banco;
import com.sistema.moneymind.domains.CentroCusto;
import com.sistema.moneymind.domains.MetaFinanceira;
import com.sistema.moneymind.domains.Usuario;
import com.sistema.moneymind.domains.enums.StatusMeta;
import com.sistema.moneymind.repositories.BancoRepository;
import com.sistema.moneymind.repositories.CentroCustoRepository;
import com.sistema.moneymind.repositories.MetaFinanceiraRepository;
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
    private MetaFinanceiraRepository metaRepo;

    @Autowired
    private CentroCustoRepository centroRepo;

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


        MetaFinanceira metaFinanceira01 = new MetaFinanceira(null, "Carro",  "10/08/2026", 60000.0, StatusMeta.EMANDAMENTO);
        MetaFinanceira metaFinanceira02 = new MetaFinanceira(null, "Moto",  "10/08/2025", 20000.0, StatusMeta.CONQUISTADA);

        metaRepo.save(metaFinanceira01);
        metaRepo.save(metaFinanceira02);


        CentroCusto centroCusto01 = new CentroCusto(null, "Centro01");
        CentroCusto centroCusto02 = new CentroCusto(null, "Centro02");

        centroRepo.save(centroCusto01);
        centroRepo.save(centroCusto02);

    }







}
