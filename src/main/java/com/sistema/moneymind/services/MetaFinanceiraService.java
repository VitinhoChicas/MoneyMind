package com.sistema.moneymind.services;


import com.sistema.moneymind.domains.Banco;
import com.sistema.moneymind.domains.MetaFinanceira;
import com.sistema.moneymind.domains.Usuario;
import com.sistema.moneymind.domains.dtos.BancoDTO;
import com.sistema.moneymind.domains.dtos.MetaFinanceiraDTO;
import com.sistema.moneymind.repositories.MetaFinanceiraRepository;
import com.sistema.moneymind.services.exceptions.DataIntegrityViolationException;
import com.sistema.moneymind.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Meta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MetaFinanceiraService {

    @Autowired
    private MetaFinanceiraRepository metaRepo;

    public List<MetaFinanceiraDTO> findAll(){
        return metaRepo.findAll().stream().map(obj -> new MetaFinanceiraDTO(obj)).collect(Collectors.toUnmodifiableList());
    }

    public MetaFinanceira findbyId(Long id){
        Optional<MetaFinanceira> obj = metaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Meta financeira  não encontrado! Id: " + id));
    }

    public MetaFinanceira findByDescricaoMeta (String descricaoMeta){
        Optional<MetaFinanceira> obj = metaRepo.findByDescricaoMeta (descricaoMeta);
        return obj.orElseThrow(() -> new ObjectNotFoundException(" Deescriçao da meta financeira não encontrado! Meta Fianceira: " + descricaoMeta));
    }


    public MetaFinanceira create(MetaFinanceiraDTO dto){
        dto.setIdMeta(null);
        MetaFinanceira obj = new MetaFinanceira(dto);
        return metaRepo.save(obj);
    }

    public MetaFinanceira update(Long id, MetaFinanceiraDTO objDto){
        objDto.setIdMeta(id);
        MetaFinanceira oldObj = findbyId(id);
        oldObj = new MetaFinanceira(objDto);
        return metaRepo.save(oldObj);
    }

    public void delete(Long id){
        MetaFinanceira obj = findbyId(id);
        if(obj.getContas().size()>0){
            throw new DataIntegrityViolationException("Meta financeira não pode ser excluido pois tem uma conta vinculado com ele");
        }
        metaRepo.deleteById(id);
    }

}
