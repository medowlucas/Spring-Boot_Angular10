package br.com.lucasviasoft.projetolucas.controller;

import br.com.lucasviasoft.projetolucas.model.Estado;
import br.com.lucasviasoft.projetolucas.repository.EstadoRepository;
import br.com.lucasviasoft.projetolucas.service.EstadoService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/disponibilidade")
public class DisponibilidadeController {


@Autowired
private EstadoRepository estadoRepository;
@Autowired
private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> getAllEstados(){
        List<Estado> estados = estadoService.listarEstados();
        return new ResponseEntity<>(estados , HttpStatus.OK);
    }

    @RequestMapping
    @GetMapping("/{id}")
    public Estado getEstadoById(@PathVariable("id") Long id) {
        return estadoRepository.findById(id).get();
    }

    @GetMapping(value = "/{sigla}")
    public ResponseEntity<Estado> buscar(@PathVariable("sigla") String sigla) throws ObjectNotFoundException {
        Estado obj = estadoService.findSigla(sigla);
        return ResponseEntity.ok().body(obj);
    }


}
