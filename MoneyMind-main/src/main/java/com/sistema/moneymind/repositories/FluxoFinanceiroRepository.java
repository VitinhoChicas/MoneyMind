package com.sistema.moneymind.repositories;

import com.sistema.moneymind.domains.FluxoFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FluxoFinanceiroRepository extends JpaRepository<FluxoFinanceiro, Long> {

    Optional<FluxoFinanceiro> findByDescricaoOperacao(String descricaoOperacao);

}
