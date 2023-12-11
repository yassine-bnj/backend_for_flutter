package org.isetn.RestControllers;

import java.util.List;
import java.util.Optional;

import org.isetn.entities.Classe;
import org.isetn.entities.Etudiant;
import org.isetn.repository.ClasseRepository;
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
@RequestMapping("class")

public class ClassController {
	@Autowired
	private ClasseRepository classeRepository;

	@PostMapping("/add")
	public Classe add(@RequestBody Classe classe) {
		System.out.println(classe.toString());
		return classeRepository.save(classe);
	}

	@GetMapping("/all")
	public List<Classe> getAll() {
		return classeRepository.findAll();
	}
	@GetMapping("/get/{id}")
	public Optional<Classe> getById(@PathVariable Long id) {
		return classeRepository.findById(id);
	}
	
	@GetMapping("/findByDepId/{id}")
	public List<Classe> getByClasseId(@PathVariable Long id) {
		return classeRepository.findByDepartementCode(id);
	}
	
	@DeleteMapping("/delete")
	public void delete(@Param("id") Long id)
	{
		Classe c =  classeRepository.findById(id).get();
		classeRepository.delete(c);
	}
	
	@PutMapping("/update")
	public Classe update(@RequestBody Classe classe) {
		System.out.println(classe.toString());
		return classeRepository.save(classe);
	}
}
