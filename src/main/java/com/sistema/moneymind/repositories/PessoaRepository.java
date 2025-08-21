package com.sistema.moneymind.repositories;

import com.sistema.moneymind.domains.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository <Pessoa, Long>{


    Optional<Pessoa> findByRazaoSocial(String razaoSocial);

}
