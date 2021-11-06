package br.com.lucasviasoft.projetolucas.respository;
import br.com.lucasviasoft.projetolucas.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryServico extends JpaRepository<Servico, Long> {
}
