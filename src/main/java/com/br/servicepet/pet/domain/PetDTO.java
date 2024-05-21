package com.br.servicepet.pet.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDTO {

    private Integer idPet;
    private String NomePet;
    private String RaçaPet;
    private String CorPet;
    private Integer IdadePet;

    public PetDTO(Pet pet) {
        idPet = pet.getIdPet();
        NomePet = pet.getNomePet();
        RaçaPet = pet.getRaçaPet();
        CorPet = pet.getCorPet();
        IdadePet = pet.getIdadePet();
    }
}
