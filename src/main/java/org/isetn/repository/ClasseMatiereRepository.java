package org.isetn.repository;

import org.isetn.entities.Classe;
import org.isetn.entities.ClasseMatiere;
import org.isetn.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseMatiereRepository extends JpaRepository<ClasseMatiere, Long> {
	public void deleteByMatiere(Matiere m);
}
