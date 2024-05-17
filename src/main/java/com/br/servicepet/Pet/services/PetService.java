package com.br.servicepet.Pet.services;

import com.br.servicepet.Pet.domain.Pet;
import com.br.servicepet.Pet.domain.PetDTO;
import com.br.servicepet.Pet.repositories.PetRepository;
import com.br.servicepet.Pet.resources.PetResource;
import com.br.servicepet.Tutor.repositories.TutorRepository;
import com.br.servicepet.exceptios.ExceptionDataIntegrityViolation;
import com.br.servicepet.exceptios.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private TutorRepository tutorRepository;
    public Pet criarPet(Pet pet) {
        try {
            pet.setIdPet(null);
            pet =  petRepository.save(pet);
            pet.setTutor(tutorRepository.findByPet_idPet(pet.getIdPet()));
            return pet;
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("O Tutor informado não existe!");
        }
    }

    public Pet buscarPet(Integer idPet) {
        Optional<Pet> obj = petRepository.findById(idPet);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrato! ID: " + idPet +
                ", Tipo: " + Pet.class.getName()));
    }

    public List<Pet> listarPet() {

        return petRepository.findAll();
    }

    public Pet atualizarPet(Pet pet) {

        Pet novoPet = buscarPet(pet.getIdPet());
        updateData(novoPet, pet);
        return petRepository.save(novoPet);
    }

    public void deletarPet(Integer id) {
        buscarPet(id);
        try {
            petRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new ExceptionDataIntegrityViolation("Existe uma associação entre o tutor e o pet." +
                    " Este procedimento não pode ser concluído!");
        }

    }
    public Pet fromDTOPet(PetDTO petDTO){
        return new Pet(petDTO.getIdPet(), petDTO.getNomePet(), petDTO.getRaçaPet(), petDTO.getCorPet(), petDTO.getIdadePet());
    }
    private void updateData(Pet novoPet, Pet pet){
        novoPet.setNomePet(pet.getNomePet());
        novoPet.setRaçaPet(pet.getRaçaPet());
        novoPet.setIdadePet(pet.getIdadePet());
        novoPet.setCorPet(pet.getCorPet());
    }
}
