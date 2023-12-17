package org.isetn.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Etudiant {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dateNais;
	@JsonIgnore
    @ManyToOne
	private Formation formation;
    
    @ManyToOne
	private Classe classe;

	@JsonIgnore
	@OneToMany(mappedBy = "etudiant", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Abscence> abscences = new ArrayList<>();



	
	
}
