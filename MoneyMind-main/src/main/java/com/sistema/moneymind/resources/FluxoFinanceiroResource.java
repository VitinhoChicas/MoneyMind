package com.sistema.moneymind.resources;

import com.sistema.moneymind.domains.FluxoFinanceiro;
import com.sistema.moneymind.domains.dtos.FluxoFinanceiroDTO;
import com.sistema.moneymind.services.FluxoFinanceiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/fluxoFinanceiro")
public class FluxoFinanceiroResource {

    @Autowired
    private FluxoFinanceiroService fluxoService;

    @GetMapping
    public ResponseEntity<List<FluxoFinanceiroDTO>> findAll() {
        return ResponseEntity.ok().body(fluxoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FluxoFinanceiroDTO> findById(@PathVariable Long id) {
        FluxoFinanceiro obj = this.fluxoService.findById(id);
        return ResponseEntity.ok().body(new FluxoFinanceiroDTO(obj));
    }

    @GetMapping(value = "/descricaoOperacao/{descricaoOperacao}")
    public ResponseEntity<FluxoFinanceiroDTO> findByDescricaoOperacao(@PathVariable String descricaoOperacao) {
        FluxoFinanceiro obj = this.fluxoService.findbyDescricaoOperacao(descricaoOperacao);
        return ResponseEntity.ok().body(new FluxoFinanceiroDTO(obj));
    }

    @PostMapping
    public ResponseEntity<FluxoFinanceiroDTO> create(@Valid @RequestBody FluxoFinanceiroDTO dto) {
        FluxoFinanceiro fluxo = fluxoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(fluxo.getIdOperacao())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FluxoFinanceiroDTO> update(@PathVariable Long id, @Valid @RequestBody FluxoFinanceiroDTO objDto) {
        FluxoFinanceiro obj = fluxoService.update(id, objDto);
        return ResponseEntity.ok().body(new FluxoFinanceiroDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fluxoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
