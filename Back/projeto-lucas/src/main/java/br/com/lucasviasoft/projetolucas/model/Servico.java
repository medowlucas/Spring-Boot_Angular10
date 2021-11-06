package br.com.lucasviasoft.projetolucas.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servico")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descricao", nullable = false)
    private ServicosEnum descricao;
    @Column(name = "servicosestados", nullable = false)
    private List<ServicoEstado> servicosEstados;

    public Servico() {
    }

    public Servico(ServicosEnum descricao) {
        this.descricao = descricao;
        this.servicosEstados = new ArrayList<ServicoEstado>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServicosEnum getDescricao() {
        return descricao;
    }

    public void setDescricao(ServicosEnum descricao) {
        this.descricao = descricao;
    }

    public List<ServicoEstado> getServicosEstados() {
        return servicosEstados;
    }

    public void setServicosEstados(List<ServicoEstado> servicosEstados) {
        this.servicosEstados = servicosEstados;
    }
}
