package com.br.servicepet.Tutor.repositories;

import com.br.servicepet.Tutor.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository <Tutor, Integer> {
    Tutor findByPet_idPet(Integer idPet);
    boolean existsByNomeTutor(String nome);
}
