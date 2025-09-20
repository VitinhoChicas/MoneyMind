package com.sistema.moneymind.repositories;

import com.sistema.moneymind.domains.MetaFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MetaFinanceiraRepository  extends JpaRepository<MetaFinanceira, Long> {


    Optional<MetaFinanceira> findByDescricaoMeta(String descricaoMeta);


}
