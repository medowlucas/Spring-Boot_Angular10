package br.com.lucasviasoft.projetolucas.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sigla", nullable = false)
    private String sigla;
    @Column(name = "nome", nullable = false)
    private AutorizadoresEnum nome;
    @OneToMany
    private List<ServicoEstado> servicosEstados;

    public Estado(){
    }

    public Estado(String sigla) {
        this.sigla = sigla;
        this.nome = AutorizadoresEnum.valueOf(sigla);
        this.servicosEstados = new ArrayList<ServicoEstado>();
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla.replaceAll("\\<[^>]*>","");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AutorizadoresEnum getNome() {
        return nome;
    }

    public void setNome(AutorizadoresEnum nome) {
        this.nome = nome;
    }

    public List<ServicoEstado> getServicosEstados() {
        return servicosEstados;
    }

    public void setServicosEstados(List<ServicoEstado> servicosEstados) {
        this.servicosEstados = servicosEstados;   }
}
