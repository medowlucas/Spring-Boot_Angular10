package br.com.lucasviasoft.projetolucas.service;

import br.com.lucasviasoft.projetolucas.model.ServicoEstado;
import br.com.lucasviasoft.projetolucas.repository.ServicoEstadoRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoEstadoService {
    private final ServicoEstadoRepository servicoEstadoRepository;

    @Autowired
    public ServicoEstadoService(ServicoEstadoRepository servicoEstadoRepository){
        this.servicoEstadoRepository = servicoEstadoRepository;
    }

    public List<ServicoEstado> findAll(){return servicoEstadoRepository.findAll();}

    public ServicoEstado findServicoEstadoById(Long id){
        return servicoEstadoRepository.getById(id);
    }

    public ServicoEstado findBySigla(String sigla) throws ObjectNotFoundException {
        Optional<ServicoEstado> obj = servicoEstadoRepository.findBySigla(sigla);
        return obj.orElseThrow(() -> new ObjectNotFoundException
                ("Estado não encontrado! UF: " + sigla + ", Tipo"+ ServicoEstadoService.class.getName()));
    }

}
