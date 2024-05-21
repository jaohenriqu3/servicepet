package com.br.servicepet.pet.repositories;

import com.br.servicepet.pet.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
    Pet findByidPet(Integer idPet);
}
