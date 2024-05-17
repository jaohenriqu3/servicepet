package com.br.servicepet.Tutor.services;

import com.br.servicepet.Tutor.repositories.TutorRepository;
import com.br.servicepet.exceptios.NomeTutorJaExistenteException;
import com.br.servicepet.exceptios.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.servicepet.Tutor.domain.Tutor;
import com.br.servicepet.Tutor.domain.TutorDTO;
import com.br.servicepet.Tutor.resources.TutorResource;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public Tutor criarTutor(Tutor tutor) {
        if (tutorRepository.existsByNomeTutor(tutor.getNomeTutor())) {
            throw new NomeTutorJaExistenteException("Já existe um tutor com esse nome");
        }
        tutor.setIdTutor(null);
        tutor.getNomeTutor();
        return tutorRepository.save(tutor);
    }
    public Tutor buscarTutorPorId(Integer id){
        Optional<Tutor> obj = tutorRepository.findById(id);return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrato! ID: " + id +
                ", Tipo: " + Tutor.class.getName()));
    }

    public List<Tutor> listarTutores() {
        return tutorRepository.findAll();
    }

    public Tutor atualizarTutor(Tutor tutor) {
        Tutor novoTutor = buscarTutorPorId(tutor.getIdTutor());
        updateData(novoTutor, tutor);
        return tutorRepository.save(novoTutor);
    }

    public void deletarTutor(Integer idTutor) {
        tutorRepository.deleteById(idTutor);
    }

    public Tutor fromDTO(TutorDTO tutorDTO){
        return new Tutor(tutorDTO.getIdTutor(), tutorDTO.getNomeTutor());
    }

    private void updateData(Tutor novoTutor, Tutor tutor){
        novoTutor.setNomeTutor(tutor.getNomeTutor());
    }
}




