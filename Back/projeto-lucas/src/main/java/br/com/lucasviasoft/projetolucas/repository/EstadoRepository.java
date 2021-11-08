package br.com.lucasviasoft.projetolucas.repository;

import br.com.lucasviasoft.projetolucas.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Optional<Estado> findBySigla(String sigla);
}
