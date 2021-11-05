package br.com.lucasviasoft.projetolucas.model;

public enum ServicosEnum {

    SERVICO1("Autorização"),
    SERVICO2("Retorno Autorização"),
    SERVICO3("Inutilização"),
    SERVICO4("Consulta Protocolo"),
    SERVICO5("Status Serviço"),
    SERVICO6("Consulta Cadastro"),
    SERVICO7("Recepção  Evento");

    private String nomeServico;

    ServicosEnum(String descricao){
        this.nomeServico = descricao;
    }

    public String getNomeServico() {
        return this.nomeServico;
    }
}
