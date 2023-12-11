package org.isetn.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClasseMatiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "codeMat") // Foreign key for Matiere
    private Matiere matiere;
   // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "classe_id") // Foreign key for Classe
    private Classe classe;

    private int nbrHs;
    private int coef;

}
