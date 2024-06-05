package com.br.servicepet.pet.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDTO {

    private Integer idPet;
    private String NomePet;
    private String RacaPet;
    private String CorPet;
    private Integer IdadePet;

    public PetDTO(){}

    public PetDTO(Pet pet) {
        idPet = pet.getIdPet();
        NomePet = pet.getNomePet();
        RacaPet = pet.getRacaPet();
        CorPet = pet.getCorPet();
        IdadePet = pet.getIdadePet();
    }
}
