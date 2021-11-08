package br.com.lucasviasoft.projetolucas.repository;

import br.com.lucasviasoft.projetolucas.model.Estado;
import br.com.lucasviasoft.projetolucas.model.Servico;
import br.com.lucasviasoft.projetolucas.model.ServicoEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServicoEstadoRepository extends JpaRepository<ServicoEstado, Long> {
    Optional<ServicoEstado> findBySigla(String sigla);
}
