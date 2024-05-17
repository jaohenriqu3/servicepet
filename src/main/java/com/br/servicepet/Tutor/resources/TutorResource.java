package com.br.servicepet.Tutor.resources;

import com.br.servicepet.Tutor.domain.Tutor;
import com.br.servicepet.Tutor.domain.TutorDTO;
import com.br.servicepet.Tutor.services.TutorService;
import com.br.servicepet.Tutor.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class TutorResource {
    @Autowired
    private TutorService TutorService;

    @PostMapping
    public ResponseEntity<Void> cadastrarTutor(@Validated @RequestBody TutorDTO tutorDTO){
        Tutor tutor = TutorService.fromDTO(tutorDTO);
        tutor = TutorService.criarTutor(tutor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(tutor.getIdTutor()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<TutorDTO>> listarTutores(){
        List<Tutor> listarTutores = TutorService.listarTutores();
        List<TutorDTO> listaDTO = listarTutores.stream().map(TutorDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }

    @GetMapping("/{idTutor}")
    public ResponseEntity<Tutor> buscarTutorPorId(@PathVariable Integer idTutor) {
        Tutor tutor = TutorService.buscarTutorPorId(idTutor);
        return ResponseEntity.ok().body(tutor);
    }

    @PutMapping("/{idTutor}")
    public ResponseEntity<Tutor> atualizarCategoria(@Validated @RequestBody TutorDTO tutorDTO, @PathVariable Integer idTutor) {
        Tutor tutor  = TutorService.fromDTO(tutorDTO);
        tutor.setIdTutor(idTutor);
        tutor = TutorService.atualizarTutor(tutor);
        return ResponseEntity.ok().body(tutor);
    }

    @DeleteMapping("/{idTutor}")
    public ResponseEntity<Void> deletarTutor(@PathVariable Integer idTutor) {
        TutorService.deletarTutor(idTutor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
