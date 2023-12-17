package org.isetn.RestControllers;

import org.isetn.entities.Abscence;
import org.isetn.entities.Classe;
import org.isetn.repository.AbscenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("abscence")

public class AbscenceController {

    @Autowired
    private AbscenceRepository abscenceRepository;


    //make crud get post put delete

    @PostMapping("/add")
    public  Abscence add(@RequestBody Abscence abscence) {
        System.out.println(abscence.toString());
        return abscenceRepository.save(abscence);
    }

    @PutMapping("/update/{id}")
    public  Abscence update(@PathVariable Long id, @RequestBody Abscence abscence) {
        System.out.println(abscence.toString());
        
        //Abscence a = abscenceRepository.findById(id).get();
        
        
        return abscenceRepository.save(abscence);
    }

    @GetMapping("/all")
    public List<Abscence> getAll() {
        return abscenceRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Abscence getById(@RequestBody Long id) {
        return abscenceRepository.findById(id).get();
    }

//    @GetMapping("/getByClasse/{id}")
//    public List<Abscence> getByClasseId(@RequestBody Long id) {
//        return abscenceRepository.findByClasseId(id);
//    }
//
    @GetMapping("/findByStudentId/{id}")
    public List<Abscence> getByEtudiantId(@PathVariable Long id) {
        return abscenceRepository.findByEtudiantId(id);
    }

    @GetMapping("/getByMatiereAndEtudiant/{idMatiere}/{idEtudiant}")
    public List<Abscence> getByMatiereAndEtudiantId(@RequestBody Long idMatiere, @RequestBody Long idEtudiant) {
        return abscenceRepository.findByMatiereCodeMatAndEtudiantId(idMatiere, idEtudiant);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id)
    {

    	abscenceRepository.deleteById(id);
    }




}
