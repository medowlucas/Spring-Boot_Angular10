package br.com.lucasviasoft.projetolucas.repository;

import br.com.lucasviasoft.projetolucas.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
