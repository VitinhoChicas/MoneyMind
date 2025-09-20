package com.sistema.moneymind.repositories;

import com.sistema.moneymind.domains.CentroCusto;
import com.sistema.moneymind.domains.MetaFinanceira;
import com.sistema.moneymind.domains.dtos.CentroCustoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CentroCustoRepository extends JpaRepository<CentroCusto, Long> {

    Optional<CentroCusto> findByDescricaoCentro(String descricaoCentro);

}
