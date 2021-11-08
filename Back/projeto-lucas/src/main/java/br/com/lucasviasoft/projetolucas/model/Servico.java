package br.com.lucasviasoft.projetolucas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico")
    private Long idServico;
    private String descricao;
    @OneToMany(mappedBy = "servico", fetch = FetchType.LAZY)
    private Set<ServicoEstado> servicoEstado;
}
