package com.sistema.moneymind.domains;


import com.sistema.moneymind.domains.dtos.CentroCustoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "centrocusto")
public class CentroCusto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_centrocusto")
    private Long idCentro;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String descricaoCentro;

    public CentroCusto() {
    }

    public CentroCusto(Long idCentro, String descricaoCentro) {
        this.idCentro = idCentro;
        this.descricaoCentro = descricaoCentro;
    }

    public CentroCusto(CentroCustoDTO centroDTO) {
        this.idCentro = centroDTO.getIdCentro();
        this.descricaoCentro = centroDTO.getDescricaoCentro();
    }



    public Long getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(Long idCentro) {
        this.idCentro = idCentro;
    }

    public @NotNull @NotBlank String getDescricaoCentro() {
        return descricaoCentro;
    }

    public void setDescricaoCentro(@NotNull @NotBlank String descricaocentro) {
        this.descricaoCentro = descricaoCentro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CentroCusto that = (CentroCusto) o;
        return Objects.equals(idCentro, that.idCentro) && Objects.equals(descricaoCentro, that.descricaoCentro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCentro, descricaoCentro);
    }
}
