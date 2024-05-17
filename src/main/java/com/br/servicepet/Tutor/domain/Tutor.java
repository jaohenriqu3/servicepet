package com.br.servicepet.Tutor.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TUTORES")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TUTOR")
    private Integer idTutor;

    @Column(name = "NOME_TUTOR")
    private String NomeTutor;

    @Column(name = "CPF_TUTOR")
    private String CpfTutor;

    @Column(name = "TELEFONE_TUTOR")
    private String TelefoneTutor;

  // @JsonIgnore
  // @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL );
  // invite List<Pet> pet;

    public Tutor(Integer idTutor, String nomeTutor ){
        this.idTutor = idTutor;
        this.NomeTutor = nomeTutor;
        this.CpfTutor = CpfTutor;
        this.TelefoneTutor = TelefoneTutor;
    }
}
