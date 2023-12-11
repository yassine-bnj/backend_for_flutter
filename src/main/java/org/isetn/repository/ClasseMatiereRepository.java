package org.isetn.repository;

import org.isetn.entities.Classe;
import org.isetn.entities.ClasseMatiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseMatiereRepository extends JpaRepository<ClasseMatiere, Long> {
}
