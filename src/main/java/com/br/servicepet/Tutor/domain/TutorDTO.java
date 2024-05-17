package com.br.servicepet.Tutor.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TutorDTO {
    private Integer idTutor;
    private String NomeTutor;
    private String CpfTutor;
    private String TelefoneTutor;

   // public TutorDTO(){}

    public TutorDTO(Tutor tutor){
        idTutor = tutor.getIdTutor();
        NomeTutor = tutor.getNomeTutor();
        CpfTutor = tutor.getCpfTutor();
        TelefoneTutor = tutor.getTelefoneTutor();
    }
}
