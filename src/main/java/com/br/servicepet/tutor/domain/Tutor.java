package com.br.servicepet.tutor.domain;

import com.br.servicepet.pet.domain.Pet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "TUTORES")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TUTOR")
    private Integer idTutor;

    @Column(name = "NOME_TUTOR")
    private String nomeTutor;

    @Column(name = "CPF_TUTOR")
    private String cpfTutor;

    @Column(name = "TELEFONE_TUTOR")
    private String telefoneTutor;

   @JsonIgnore
   @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
   private List<Pet> pet;

    public Tutor() {
    }

    public Tutor(Integer idTutor, String nomeTutor, String cpfTutor, String telefoneTutor) {
        this.idTutor = idTutor;
        this.nomeTutor = nomeTutor;
        this.cpfTutor = cpfTutor;
        this.telefoneTutor = telefoneTutor;
    }
}
