package org.isetn.RestControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.isetn.entities.Classe;
import org.isetn.entities.ClasseMatiere;
import org.isetn.entities.Departement;
import org.isetn.entities.Matiere;
import org.isetn.repository.ClasseMatiereRepository;
import org.isetn.repository.ClasseRepository;
import org.isetn.repository.DepartementRepository;
import org.isetn.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("matiere")
public class MatiereController {

	
	@Autowired
	private MatiereRepository matRepository;

	@Autowired
	private ClasseMatiereRepository classeMatRepository;

	@Autowired
	private ClasseRepository classeRepository;


	@PostMapping("/ajouter")
	public ResponseEntity<Matiere> ajouterMatiere(@RequestBody Map<String, Object> requestBody) {
		// Récupérez les attributs nécessaires pour créer votre objet Matiere
		String nomMat = (String) requestBody.get("nomMat");
		System.out.println("nomMat : " + nomMat);
		String intitule = (String) requestBody.get("intitule");
		System.out.println("intitule : " + intitule);
		Integer coef = (Integer) requestBody.get("coef");
		System.out.println("coef : " + coef);
		Integer nbrHs = (Integer) requestBody.get("nbrHs");
		System.out.println("nbrHs : " + nbrHs);
		List<Map<String, Object>> classesData = (List<Map<String, Object>>) requestBody.get("classes");
		System.out.println("classesData : " + classesData.toString());

		// Créez votre objet Matiere
		Matiere matiere = new Matiere();
		matiere.setNomMat(nomMat);
		matiere.setIntitule(intitule);
//		matiere.setCoef(coef);
//		matiere.setNbrHs(nbrHs);

		// Enregistrez votre objet Matiere
		Matiere nouvelleMatiere = matRepository.save(matiere);

		// Traitez la liste de classes si elle est présente
		if (classesData != null) {
			for (Map<String, Object> classeData : classesData) {
				Classe classe = new Classe();
//				classe.setCodClass((Long) classeData.get("codClass"));
				classe.setCodClass(((Integer) classeData.get("codClass")).longValue());

				classe.setNomClass((String) classeData.get("nomClass"));
				classe.setNbreEtud((Integer) classeData.get("nbreEtud"));

				// Set other properties if needed

				// Save the Classe instance
				//classeRepository.save(classe);
               classe = classeRepository.findById(classe.getCodClass()).get();
				// Create and save ClasseMatiere instance
				ClasseMatiere classeMat = new ClasseMatiere();
				classeMat.setCoef(coef);
				classeMat.setNbrHs(nbrHs);
				classeMat.setClasse(classe);
				classeMat.setMatiere(nouvelleMatiere);
				classeMatRepository.save(classeMat);
			}
		}

		return new ResponseEntity<>(nouvelleMatiere, HttpStatus.CREATED);
	}

//	@PostMapping("/ajouter")
//	public ResponseEntity<Matiere> ajouterMatiere(@RequestBody Map<String, Object> requestBody) {
//		// Récupérez les attributs nécessaires pour créer votre objet Matiere
//		String nomMat = (String) requestBody.get("nomMat");
//		System.out.println("nomMat : " + nomMat);
//		String intitule = (String) requestBody.get("intitule");
//		System.out.println("intitule : " + intitule);
//		Integer coef = (Integer) requestBody.get("coef");
//		System.out.println("coef : " + coef);
//		Integer nbrHs = (Integer) requestBody.get("nbrHs");
//		System.out.println("nbrHs : " + nbrHs);
//		List<Classe> classesData = (List<Classe>) requestBody.get("classes");
//		System.out.println("classesData : " + classesData.toString());
//
//		// Créez votre objet Matiere
//		Matiere matiere = new Matiere();
//		matiere.setNomMat(nomMat);
//		matiere.setIntitule(intitule);
////		matiere.setCoef(coef);
////		matiere.setNbrHs(nbrHs);
//		// Enregistrez votre objet Matiere
//		Matiere nouvelleMatiere = matRepository.save(matiere);
//		// Traitez la liste de classes si elle est présente
//		if (classesData != null) {
//			List<Classe> classes = new ArrayList<>();
//			for (Classe classeData : classesData) {
//
//				ClasseMatiere classeMat = new ClasseMatiere();
//				classeMat.setCoef(coef);
//				classeMat.setNbrHs(nbrHs);
//				classeMat.setClasse(classeData);
//                classeMat.setMatiere(nouvelleMatiere);
//				classeMatRepository.save(classeMat);
//
//
//			}
//
//		}


//
//		return new ResponseEntity<>(nouvelleMatiere, HttpStatus.CREATED);
//	}






	@PostMapping("/add")
	public Matiere add(@RequestBody Matiere m ) {

		return matRepository.save(m);
	}

	@GetMapping("/all")
	public List<Matiere> getAll() {
		return matRepository.findAll();
	}
	/*
	@GetMapping("/findByClasseId/{id}")
	public List<Departement> getByDepartementId(@PathVariable Long id) {
		return depRepository.findByDepartementCodClass(id);
	}*/
	
	@GetMapping("/get/{id}")
	public Optional<Matiere> getById(@PathVariable Long id) {
		return matRepository.findById(id);
	}
	
	
	
	@DeleteMapping("/delete")
	public void delete(@Param("id") Long id)
	{
		Matiere m =  matRepository.findById(id).get();
		matRepository.delete(m);
	}
	
	@PutMapping("/update")
	public Matiere update(@RequestBody Matiere m) {
		return matRepository.save(m);
	}
	
	
}
