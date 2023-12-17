package org.isetn.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Abscence  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Matiere matiere;

    @ManyToOne
    private Etudiant etudiant;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    private double nha;
}
