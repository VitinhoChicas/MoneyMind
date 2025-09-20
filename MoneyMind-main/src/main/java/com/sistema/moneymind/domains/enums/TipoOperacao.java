package com.sistema.moneymind.domains.enums;

public enum TipoOperacao {
    CREDITO(1, "Credito"), DEBITO(2, "Debito");
    private Integer id;
    private String descricao;

    TipoOperacao(Integer id, String descricao) {
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


    public static TipoOperacao toEnum(Integer id){
        if(id == null) return null;
        for (TipoOperacao c : TipoOperacao.values()){
            if(id.equals(c.getId())){
                return c;
            }
        }

        throw new IllegalArgumentException("Situacao inváldia");
    }


}
