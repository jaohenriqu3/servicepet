package com.br.servicepet.Pet.resources;

import com.br.servicepet.Pet.domain.Pet;
import com.br.servicepet.Pet.domain.PetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.br.servicepet.Pet.services.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pet")
public class PetResource {
    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<Pet> criarPet(@RequestBody PetDTO petDTO) {
        Pet pet = petService.fromDTOPet(petDTO);
        pet = petService.criarPet(pet);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(pet.getIdPet()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Pet>> listarPet() {
        List<Pet> pets = petService.listarPet();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/{idPet}")
    public ResponseEntity<Pet> buscarPet(@PathVariable Integer idPet) {
        Pet pet = petService.buscarPet(idPet);
        return ResponseEntity.ok().body(pet);
    }
    @PutMapping("/{idPet}")
    public ResponseEntity<Pet> atualizarPet(@PathVariable Integer idPet, @RequestBody PetDTO petDTO) {
        Pet pet = petService.fromDTOPet(petDTO);
        pet.setIdPet(idPet);petService.atualizarPet(pet);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{idPet}")
    public ResponseEntity<Void> deletarPet(@PathVariable Integer idPet) {
        petService.deletarPet(idPet);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
