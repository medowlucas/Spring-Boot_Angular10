package br.com.lucasviasoft.projetolucas.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "statusservicoestado")
public class StatusServicoEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "idservicoestado", nullable = false)
    private Long idServicoEstado;
    @Column(name = "data", nullable = false)
    private LocalDate data;
    @Column(name = "status", nullable = false)
    private String status;

    public StatusServicoEstado(Long idServicoEstado,String status) {
        this.idServicoEstado = idServicoEstado;
        this.status = status;
        this.data = LocalDate.now();
    }

    public Long getIdServicoEstado() {
        return idServicoEstado;
    }

    public void setIdServicoEstado(Long idServicoEstado) {
        this.idServicoEstado = idServicoEstado;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String c = status.replaceAll("\\<[^>]*>","");
        if (c.contains("verde")) {
            c = StatusEnum.Verde.toString();
        }else if (c.contains("amarelo")) {
            c = StatusEnum.Amarelo.toString();
        }else if  (c.contains("vermelho")) {
            c = StatusEnum.Vermelho.toString();
        }else{
            c = StatusEnum.Vazio.toString();
        }
        this.status = c;
    }
}
