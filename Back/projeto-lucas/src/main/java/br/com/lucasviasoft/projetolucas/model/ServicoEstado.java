package br.com.lucasviasoft.projetolucas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoEstado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "id_estado")
    Estado estado;
    @ManyToOne
    @JoinColumn(name = "id_servico")
    Servico servico;
    String status;
    LocalDateTime historicoData;

    public void setStatus(String status) {
        String c = status;
        if (c.contains("verde")) {
            c = "disponivel";
        }else if (c.contains("amarelo")) {
            c = "falha recente";
        }else if  (c.contains("vermelho")) {
            c = "indisponivel";
        }else{
            c = "sem informacao";
        }
        this.status = c;
    }

    public ServicoEstado clonarServicoEstado(){
        ServicoEstado servicoEstado = new ServicoEstado();
        servicoEstado.setEstado(this.estado);
        servicoEstado.setServico(this.servico);
        servicoEstado.setHistoricoData(this.historicoData);
        return servicoEstado;
    }
}
