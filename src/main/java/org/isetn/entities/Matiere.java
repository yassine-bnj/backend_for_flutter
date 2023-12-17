package org.isetn.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Matiere {

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeMat;
	private String intitule;
	private String nomMat;
//	private int nbrHs;
//	private int coef;

	@OneToMany(mappedBy = "matiere", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	@JsonIgnore
	private List<ClasseMatiere> classeMatieres;


	@JsonIgnore
	@OneToMany(mappedBy = "matiere")
	private List<Abscence> abscences=new ArrayList<>();


	
	
	/*
	 * codeMat
	 * intitulé
	 * nomMat
	 * nbrHs
	 * coef
	 * classe : manytomany
	*/
}
