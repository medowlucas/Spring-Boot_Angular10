package br.com.lucasviasoft.projetolucas.model;

public enum StatusEnum {

    Vermelho("Indisponível"),
    Amarelo("Indisponível"),
    Verde("Disponível"),
    Vazio("Sem descrição");

    private String descricao;

    StatusEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

}
