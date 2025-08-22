package com.sistema.moneymind.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.moneymind.domains.dtos.BancoDTO;
import com.sistema.moneymind.domains.dtos.UsuarioDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "banco")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_banco")
    private Long idBanco;

    @NotNull @NotBlank
    @Column(unique = true)
    private String razaoSocial;

    @JsonIgnore
    @OneToMany(mappedBy = "banco")
    private List<Conta> contas = new ArrayList<>();

    public Banco() {
    }

    public Banco(Long idBanco, String razaoSocial) {
        this.idBanco = idBanco;
        this.razaoSocial = razaoSocial;
    }


    public Banco(BancoDTO bancoDTO){
        this.idBanco = bancoDTO.getIdBanco();
        this.razaoSocial = bancoDTO.getRazaoSocial();
    }




    public Long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Long idBanco) {
        this.idBanco = idBanco;
    }

    public @NotNull @NotBlank String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(@NotNull @NotBlank String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return Objects.equals(idBanco, banco.idBanco) && Objects.equals(razaoSocial, banco.razaoSocial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBanco, razaoSocial);
    }
}


