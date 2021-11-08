package br.com.lucasviasoft.projetolucas.service;

import br.com.lucasviasoft.projetolucas.model.Estado;
import br.com.lucasviasoft.projetolucas.repository.EstadoRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    private final EstadoRepository estadoRepository;

    @Autowired
    public EstadoService(EstadoRepository estadoRepository){
        this.estadoRepository = estadoRepository;
    }

    public List<Estado> listarEstados(){return estadoRepository.findAll();}

    public Estado findEstadoById(Long id){
        return estadoRepository.getById(id);
    }

    public Estado findSigla(String sigla) throws ObjectNotFoundException {
        Optional<Estado> obj = estadoRepository.findBySigla(sigla);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Estado não encontrado! UF: " + sigla + ", Tipo"+ EstadoService.class.getName()));
    }

}
