package br.com.lucasviasoft.projetolucas.repository;

import br.com.lucasviasoft.projetolucas.model.ServicoEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoEstadoRepository extends JpaRepository<ServicoEstado, Long> {
}
