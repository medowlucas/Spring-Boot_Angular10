package br.com.lucasviasoft.projetolucas.model;

import javax.persistence.*;

@Entity
@Table(name = "servicoestado")
public class ServicoEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "idestado", nullable = false)
    private Long idEstado;
    @Column(name = "idservico", nullable = false)
    private Long idServico;
    @Column(name = "status", nullable = false)
    private String status;

    public ServicoEstado() {
    }

    public ServicoEstado(Long idEstado, Long idServico, String status) {
        this.idEstado = idEstado;
        this.idServico = idServico;
        this.status = status;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

}
