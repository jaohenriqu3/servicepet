package com.br.servicepet.pet.domain;

import com.br.servicepet.tutor.domain.Tutor;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PETS")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PET")
    private Integer idPet;

    @Column(name = "NOME_PET")
    private String NomePet;

    @Column(name = "RAÇA_PET")
    private String RaçaPet;

    @Column(name = "COR_PET")
    private String CorPet;

    @Column(name = "IDADE_PET")
    private Integer IdadePet;

    @ManyToOne
    @JoinColumn(name = "idTutor")
    private Tutor tutor;

    public Pet() {
    }

    public Pet(Integer idPET, String NomePet, String RaçaPet, String CorPet, Integer IdadePet){
        this.idPet = idPET;
        this.NomePet = NomePet;
        this.RaçaPet = RaçaPet;
        this.CorPet = CorPet;
        this.IdadePet = IdadePet;
    }
}
