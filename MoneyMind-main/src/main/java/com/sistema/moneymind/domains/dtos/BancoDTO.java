package com.sistema.moneymind.domains.dtos;

import com.sistema.moneymind.domains.Banco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class BancoDTO {


    private Long idBanco;

    @NotNull(message = "O campo razaoSocial não pode ser nulo")
    @NotBlank(message = "O campo razaoSocial não pode estar vazio")
    private String razaoSocial;

    public BancoDTO() {
    }

    public BancoDTO(Banco banco) {
        this.idBanco = banco.getIdBanco();
        this.razaoSocial = banco.getRazaoSocial();
    }

    public Long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Long IdBanco) {
        this.idBanco = IdBanco;
    }

    public @NotNull(message = "O campo razaoSocial não pode ser nulo") @NotBlank(message = "O campo razaoSocial não pode estar vazio") String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotNull(message = "O campo razaoSocial não pode ser nulo") @NotBlank(message = "O campo razaoSocial não pode estar vazio") String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BancoDTO bancoDTO = (BancoDTO) o;
        return Objects.equals(idBanco, bancoDTO.idBanco) && Objects.equals(razaoSocial, bancoDTO.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBanco, razaoSocial);
    }
}