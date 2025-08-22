package com.sistema.moneymind.domains.enums;

public enum TipoConta {

    CONTACORRENTE(1, "Conta Corrente"), CONTAINVESTIMENTO(2, "Conta Investimento"),  CARTAOCREDITO(3, "Cartão de Crédito"), ALIMENTACAO(4, "Ticket de Alimentação"), POUPANCA(5, "Poupança");
    private Integer id;
    private String descricao;

    TipoConta(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public static TipoConta toEnum(Integer id){
        if(id == null) return null;
        for (TipoConta c : TipoConta.values()){
            if(id.equals(c.getId())){
                return c;
            }
        }

        throw new IllegalArgumentException("Tipo de conta inváldia");
    }


}