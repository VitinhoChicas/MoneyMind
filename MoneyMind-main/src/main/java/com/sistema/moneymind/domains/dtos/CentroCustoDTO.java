package com.sistema.moneymind.domains.dtos;

import com.sistema.moneymind.domains.CentroCusto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class CentroCustoDTO {

    private Long idCentro;

    @NotNull(message = "O campo descricaoCentro não pode ser nulo")
    @NotBlank(message = "O campo descricaoCentro não pode estar vazio")
    private String descricaoCentro;


    public CentroCustoDTO() {
    }


    public CentroCustoDTO(CentroCusto centro) {
        this.idCentro = centro.getIdCentro();
        this.descricaoCentro = centro.getDescricaoCentro();
    }

    public Long getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(Long idCentro) {
        this.idCentro = idCentro;
    }

    public @NotNull(message = "O campo descricaoCentro não pode ser nulo") @NotBlank(message = "O campo descricaoCentro não pode estar vazio") String getDescricaoCentro() {
        return descricaoCentro;
    }

    public void setDescricaoCentro(@NotNull(message = "O campo descricaoCentro não pode ser nulo") @NotBlank(message = "O campo descricaoCentro não pode estar vazio") String descricaoCentro) {
        this.descricaoCentro = descricaoCentro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CentroCustoDTO that = (CentroCustoDTO) o;
        return Objects.equals(idCentro, that.idCentro) && Objects.equals(descricaoCentro, that.descricaoCentro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCentro, descricaoCentro);
    }
}
