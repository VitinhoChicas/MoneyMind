package com.sistema.moneymind.domains.enums;



public enum StatusMeta {

    EMANDAMENTO(1, "Meta em andamento"), CONQUISTADA(2, "Meta Conquistada");
    private Integer id;
    private String descricao;

    StatusMeta(Integer id,String descricao) {
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

    public static StatusMeta toEnum(Integer id){
        if (id==null) return null;
        for (StatusMeta c : StatusMeta.values()){ //Para cada valor c presente em Conservacao.values(), faça o bloco de código que segue
            if (id.equals(c.getId())){ // se o id do valor c for igual ao id que está sendo comparado
                return c; //retorne o valor correspondente de Conservacao
            }
        }

        throw new IllegalArgumentException("Status da Meta Inválido");
    }
}
