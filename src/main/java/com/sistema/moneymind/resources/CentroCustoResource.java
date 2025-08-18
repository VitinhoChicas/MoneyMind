package com.sistema.moneymind.resources;


import com.sistema.moneymind.domains.Banco;
import com.sistema.moneymind.domains.CentroCusto;
import com.sistema.moneymind.domains.dtos.BancoDTO;
import com.sistema.moneymind.domains.dtos.CentroCustoDTO;
import com.sistema.moneymind.services.CentroCustoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/centrocusto")
public class CentroCustoResource {

    @Autowired
    private CentroCustoService centroService;

    @GetMapping
    public ResponseEntity<List<CentroCustoDTO>> findAll(){
        return ResponseEntity.ok().body(centroService.findAll());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CentroCustoDTO> findById(@PathVariable Long id){
        CentroCusto obj = this.centroService.findbyId(id);
        return ResponseEntity.ok().body(new CentroCustoDTO(obj));
    }


    @GetMapping(value = "/descricaoCentro/{descricaoCentro}")
    public ResponseEntity<CentroCustoDTO> findByDescricaoCentro(@PathVariable String descricaoCentro){
        CentroCusto obj = this.centroService.findByDescricaoCentro(descricaoCentro);
        return ResponseEntity.ok().body(new CentroCustoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<CentroCustoDTO> create(@Valid @RequestBody CentroCustoDTO dto){
        CentroCusto centro = centroService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(centro.getIdCentro()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CentroCustoDTO> update(@PathVariable Long id, @Valid @RequestBody CentroCustoDTO objDTO){
        CentroCusto Obj = centroService.update(id, objDTO);
        return ResponseEntity.ok().body(new CentroCustoDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CentroCustoDTO> delete(@PathVariable Long id){
        centroService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
