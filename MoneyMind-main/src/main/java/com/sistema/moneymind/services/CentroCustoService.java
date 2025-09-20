package com.sistema.moneymind.services;


import com.sistema.moneymind.domains.Banco;
import com.sistema.moneymind.domains.CentroCusto;
import com.sistema.moneymind.domains.dtos.BancoDTO;
import com.sistema.moneymind.domains.dtos.CentroCustoDTO;
import com.sistema.moneymind.repositories.CentroCustoRepository;
import com.sistema.moneymind.services.exceptions.DataIntegrityViolationException;
import com.sistema.moneymind.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CentroCustoService {


    @Autowired
    private CentroCustoRepository centroRepo;


    public List<CentroCustoDTO> findAll(){
        return centroRepo.findAll().stream().map(obj -> new CentroCustoDTO(obj)).collect(Collectors.toUnmodifiableList());
    }

    public CentroCusto findbyId(Long id){
        Optional<CentroCusto> obj = centroRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Centro de custo  não encontrado! Id: " + id));
    }

    public CentroCusto findByDescricaoCentro (String descricaoCentro){
        Optional<CentroCusto> obj = centroRepo.findByDescricaoCentro (descricaoCentro);
        return obj.orElseThrow(() -> new ObjectNotFoundException(" Descrição Centro de Custo não encontrado! Descrição Centro de Custo: " + descricaoCentro));
    }


    public CentroCusto create(CentroCustoDTO dto){
        dto.setIdCentro(null);
        validaCentro(dto);
        CentroCusto obj = new CentroCusto(dto);
        return centroRepo.save(obj);
    }


    private void validaCentro(CentroCustoDTO dto){
        Optional<CentroCusto> obj = centroRepo.findByDescricaoCentro(dto.getDescricaoCentro());
        if(obj.isPresent() && obj.get().getIdCentro() != dto.getIdCentro()){
            throw new DataIntegrityViolationException("Centro de Custo já cadastrado");
        }
    }


    public CentroCusto update(Long id, CentroCustoDTO objDto){
        objDto.setIdCentro(id);
        CentroCusto oldObj = findbyId(id);
        oldObj = new CentroCusto(objDto);
        return centroRepo.save(oldObj);
    }

    public void delete(Long id){
        CentroCusto obj = findbyId(id);
        centroRepo.deleteById(id);
    }



}
