package com.sistema.moneymind.domains.dtos;

import com.sistema.moneymind.domains.FluxoFinanceiro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class FluxoFinanceiroDTO {

    private Long idOperacao;

    @NotNull(message = "O campo valorOperacao não pode ser nulo")
    private Double valorOperacao;

    @NotNull(message = "O campo descricaoOperacao não pode ser nulo")
    @NotBlank(message = "O campo descricaoOperacao não pode ser vazio")
    private String descricaoOperacao;

    @NotNull(message = "O campo dataOperacao não pode ser nulo")
    private Date dataOperacao;

    private Date dataVencimento;

    private String parcela;

    @NotNull(message = "O campo situacao é requirido")
    private int situacao;

    @NotNull(message = "O campo tipoOperacao é requirido")
    private int tipoOperacao;

    @NotNull(message = "O campo conta é requirido")
    private Long conta;

    @NotNull(message = "O campo centroCusto é requirido")
    private Long centroCusto;

    @NotNull(message = "O campo pessoa é requirido")
    private Long pessoa;

    public FluxoFinanceiroDTO() {
    }

    public FluxoFinanceiroDTO(FluxoFinanceiro fluxo) {
        this.idOperacao = fluxo.getIdOperacao();
        this.valorOperacao = fluxo.getValorOperacao();
        this.descricaoOperacao = fluxo.getDescricaoOperacao();
        this.dataOperacao = fluxo.getDataOperacao();
        this.dataVencimento = fluxo.getDataVencimento();
        this.parcela = fluxo.getParcela();
        this.situacao = fluxo.getSituacao().getId();
        this.tipoOperacao = fluxo.getTipoOperacao().getId();
        this.conta = fluxo.getConta().getIdConta();
        this.centroCusto = fluxo.getCentroCusto().getIdCentro();
        this.pessoa = fluxo.getPessoa().getIdPessoa();
    }

    public Long getIdOperacao() {
        return idOperacao;
    }

    public void setIdOperacao(Long idOperacao) {
        this.idOperacao = idOperacao;
    }

    public Double getValorOperacao() {
        return valorOperacao;
    }

    public void setValorOperacao(Double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    public String getDescricaoOperacao() {
        return descricaoOperacao;
    }

    public void setDescricaoOperacao(String descricaoOperacao) {
        this.descricaoOperacao = descricaoOperacao;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public int getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(int tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Long getConta() {
        return conta;
    }

    public void setConta(Long conta) {
        this.conta = conta;
    }

    public Long getCentroCusto() {
        return centroCusto;
    }

    public void setCentroCusto(Long centroCusto) {
        this.centroCusto = centroCusto;
    }

    public Long getPessoa() {
        return pessoa;
    }

    public void setPessoa(Long pessoa) {
        this.pessoa = pessoa;
    }
}
