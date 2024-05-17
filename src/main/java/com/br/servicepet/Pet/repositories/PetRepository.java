package com.br.servicepet.Pet.repositories;

import com.br.servicepet.Pet.domain.Pet;
import com.br.servicepet.Tutor.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    Pet findByPet_idPet(Integer idPet);
}
