package org.isetn.repository;

import org.isetn.entities.Abscence;
import org.isetn.entities.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbscenceRepository extends JpaRepository<Abscence, Long> {



        public List<Abscence> findByMatiereCodeMatAndEtudiantId(Long idMatiere, Long idEtudiant);

        public List<Abscence> findByEtudiantId(Long idEtudiant);



}
