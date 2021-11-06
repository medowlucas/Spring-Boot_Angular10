package br.com.lucasviasoft.projetolucas.respository;
import br.com.lucasviasoft.projetolucas.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEstado extends JpaRepository<Estado, Long> {
}
