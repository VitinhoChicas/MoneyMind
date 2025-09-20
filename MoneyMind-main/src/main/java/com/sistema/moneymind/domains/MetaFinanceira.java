package com.sistema.moneymind.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistema.moneymind.domains.dtos.MetaFinanceiraDTO;
import com.sistema.moneymind.domains.enums.StatusMeta;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "metafinanceira")
public class MetaFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_meta")
    private Long idMeta;

    @NotNull@NotBlank
    private String descricaoMeta;

    @NotBlank @NotNull
    private String prazo;

    @NotNull
    private Double valor;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "metafinanceira")
    private StatusMeta statusMeta;

    @JsonIgnore
    @OneToMany(mappedBy = "metaFinanceira")
    private List<Conta> contas = new ArrayList<>();

    public MetaFinanceira() {

        this.statusMeta = StatusMeta.EMANDAMENTO;

    }

    public MetaFinanceira(Long idMeta, String descricaoMeta, String prazo, Double valor, StatusMeta statusMeta) {
        this.idMeta = idMeta;
        this.descricaoMeta = descricaoMeta;
        this.prazo = prazo;
        this.valor = valor;
        this.statusMeta = statusMeta;
    }

    public MetaFinanceira(MetaFinanceiraDTO dto){
        this.idMeta = dto.getIdMeta();
        this.descricaoMeta = dto.getDescricaoMeta();
        this.prazo = dto.getPrazo();
        this.valor = dto.getValor();
        this.statusMeta = StatusMeta.toEnum(dto.getStatusMeta());
    }

    public Long getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(Long idMeta) {
        this.idMeta = idMeta;
    }

    public @NotNull @NotBlank String getDescricaoMeta() {
        return descricaoMeta;
    }

    public void setDescricaoMeta(@NotNull @NotBlank String descricaoMeta) {
        this.descricaoMeta = descricaoMeta;
    }

    public @NotBlank @NotNull String getPrazo() {
        return prazo;
    }

    public void setPrazo(@NotBlank @NotNull String prazo) {
        this.prazo = prazo;
    }

    public @NotNull Double getValor() {
        return valor;
    }

    public void setValor(@NotNull Double valor) {
        this.valor = valor;
    }

    public StatusMeta getStatusMeta() {
        return statusMeta;
    }

    public void setStatusMeta(StatusMeta statusMeta) {
        this.statusMeta = statusMeta;
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
        MetaFinanceira that = (MetaFinanceira) o;
        return Objects.equals(idMeta, that.idMeta) && Objects.equals(descricaoMeta, that.descricaoMeta) && Objects.equals(prazo, that.prazo) && Objects.equals(valor, that.valor) && statusMeta == that.statusMeta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMeta, descricaoMeta, prazo, valor, statusMeta);
    }
}
