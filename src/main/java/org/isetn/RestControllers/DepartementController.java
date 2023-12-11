package org.isetn.RestControllers;

import java.util.List;
import java.util.Optional;

import org.isetn.entities.Departement;
import org.isetn.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("departement")
public class DepartementController {

	
	@Autowired
	private DepartementRepository depRepository;

	@PostMapping("/add")
	public Departement add(@RequestBody Departement dep ) {

		return depRepository.save(dep);
	}

	@GetMapping("/all")
	public List<Departement> getAll() {
		return depRepository.findAll();
	}
	/*
	@GetMapping("/findByClasseId/{id}")
	public List<Departement> getByDepartementId(@PathVariable Long id) {
		return depRepository.findByDepartementCodClass(id);
	}*/
	
	@GetMapping("/get/{id}")
	public Optional<Departement> getById(@PathVariable Long id) {
		return depRepository.findById(id);
	}
	
	
	
	@DeleteMapping("/delete")
	public void delete(@Param("id") Long id)
	{
		Departement c =  depRepository.findById(id).get();
		depRepository.delete(c);
	}
	
	@PutMapping("/update")
	public Departement update(@RequestBody Departement etudiant) {
		return depRepository.save(etudiant);
	}
}
