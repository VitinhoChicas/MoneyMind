package com.sistema.moneymind.repositories;

import com.sistema.moneymind.domains.Banco;
import com.sistema.moneymind.domains.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BancoRepository extends JpaRepository <Banco, Long> {


    Optional<Banco> findByRazaoSocial(String razaoSocial);


}
