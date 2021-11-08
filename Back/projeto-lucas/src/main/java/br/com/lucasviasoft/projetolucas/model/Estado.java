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
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;
    private String sigla;
    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    private Set<ServicoEstado> servicoEstado;

}
