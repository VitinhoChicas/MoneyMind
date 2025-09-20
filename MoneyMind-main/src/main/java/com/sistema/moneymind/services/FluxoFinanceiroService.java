package com.sistema.moneymind.services;

import com.sistema.moneymind.domains.Conta;
import com.sistema.moneymind.domains.CentroCusto;
import com.sistema.moneymind.domains.FluxoFinanceiro;
import com.sistema.moneymind.domains.Pessoa;
import com.sistema.moneymind.domains.dtos.FluxoFinanceiroDTO;
import com.sistema.moneymind.repositories.ContaRepository;
import com.sistema.moneymind.repositories.CentroCustoRepository;
import com.sistema.moneymind.repositories.FluxoFinanceiroRepository;
import com.sistema.moneymind.repositories.PessoaRepository;
import com.sistema.moneymind.services.exceptions.DataIntegrityViolationException;
import com.sistema.moneymind.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FluxoFinanceiroService {

    @Autowired
    private ContaRepository contaRepo;

    @Autowired
    private CentroCustoRepository centroRepo;

    @Autowired
    private PessoaRepository pessoaRepo;

    @Autowired
    private FluxoFinanceiroRepository fluxoRepo;

    public List<FluxoFinanceiroDTO> findAll() {
        return fluxoRepo.findAll().stream().map(FluxoFinanceiroDTO::new).collect(Collectors.toList());
    }

    public FluxoFinanceiro findById(Long id) {
        Optional<FluxoFinanceiro> obj = fluxoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Fluxo Financeiro não encontrado Id: " + id));
    }

    public FluxoFinanceiro findbyDescricaoOperacao(String descricao) {
        Optional<FluxoFinanceiro> obj = fluxoRepo.findByDescricaoOperacao(descricao);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Fluxo Financeiro não encontrado Descricao: " + descricao));
    }

    public FluxoFinanceiro create(FluxoFinanceiroDTO dto) {
        dto.setIdOperacao(null);
        validaFluxo(dto);
        FluxoFinanceiro obj = new FluxoFinanceiro(dto);
        return fluxoRepo.save(obj);
    }

    private void validaFluxo(FluxoFinanceiroDTO dto) {
        Optional<Conta> conta = contaRepo.findById(dto.getConta());
        if (!conta.isPresent()) {
            throw new DataIntegrityViolationException("Conta - " + dto.getConta() + " não está cadastrada");
        }

        Optional<CentroCusto> centroCusto = centroRepo.findById(dto.getCentroCusto());
        if (!centroCusto.isPresent()) {
            throw new DataIntegrityViolationException("Centro de Custo - " + dto.getCentroCusto() + " não está cadastrado");
        }

        Optional<Pessoa> pessoa = pessoaRepo.findById(dto.getPessoa());
        if (!pessoa.isPresent()) {
            throw new DataIntegrityViolationException("Pessoa - " + dto.getPessoa() + " não está cadastrada");
        }
    }

    public FluxoFinanceiro update(Long id, FluxoFinanceiroDTO dto) {
        dto.setIdOperacao(id);
        FluxoFinanceiro oldObj = findById(id);
        oldObj = new FluxoFinanceiro(dto);
        validaFluxo(dto);
        return fluxoRepo.save(oldObj);
    }

    public void delete(Long id) {
        FluxoFinanceiro obj = findById(id);
        fluxoRepo.deleteById(id);
    }
}
