package br.com.lucasviasoft.projetolucas.model;

import java.util.Date;

public class Servico {

    private Date data;
    private ServicosEnum nome;
    private StatusEnum status;

    public Servico() {
    }

    public Servico(Date data, ServicosEnum nome, StatusEnum status) {
        this.data = data;
        this.nome = nome;
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ServicosEnum getNome() {
        return nome;
    }

    public void setNome(ServicosEnum nome) {
        this.nome = nome;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

}
