package org.isetn;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.isetn.entities.Abscence;
import org.isetn.entities.Classe;
import org.isetn.entities.ClasseMatiere;
import org.isetn.entities.Departement;
import org.isetn.entities.Etudiant;
import org.isetn.entities.Formation;
import org.isetn.entities.Matiere;
import org.isetn.entities.User;
import org.isetn.repository.AbscenceRepository;
import org.isetn.repository.ClasseMatiereRepository;
import org.isetn.repository.ClasseRepository;
import org.isetn.repository.DepartementRepository;
import org.isetn.repository.EtudiantRepository;
import org.isetn.repository.FormationRepository;
import org.isetn.repository.MatiereRepository;
import org.isetn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ScolA7Application implements CommandLineRunner {
	@Autowired
	private FormationRepository formationRepository;

	@Autowired
	private ClasseRepository classeRepository;

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DepartementRepository depRepository;
	@Autowired
	private MatiereRepository matiereRepository;
	@Autowired
	private ClasseMatiereRepository classeMatiereRepository;
    @Autowired
    private AbscenceRepository abscenceRepository;

	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ScolA7Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Etudiant et = new Etudiant(null, "Ali", "Ben Ali", new Date());
		//etudiantRepository.save(et);
		//ou
		
		Departement ti= depRepository.save(new Departement(null,"TI",null));
		Departement ge= depRepository.save(new Departement(null,"GE",null));
		Departement gc= depRepository.save(new Departement(null,"GC",null));

		Formation f1 = formationRepository.save(new Formation(null,"Oracle",100,null));
		Formation f2 = formationRepository.save(new Formation(null,"J2EE",10,null));
		Formation f3 = formationRepository.save(new Formation(null,"Angular",120,null));

		Classe c1 = classeRepository.save(new Classe(null,"DSI31",27,null,null,ti));
		Classe c2 = classeRepository.save(new Classe(null,"DSI32",25,null,null,ti));
		Classe c3 = classeRepository.save(new Classe(null,"DSI33",20,null,null,ti));
		Classe c4 = classeRepository.save(new Classe(null,"GC11",20,null,null,gc));
		User u1 = userRepository.save(new User(null,"admin@gmail.com","admin"));


		SimpleDateFormat fdate = new SimpleDateFormat("dd-MM-yyyy");
		//new SimpleDateFormat("yyyy-mm-dd").parse("2020-01-01")


	Etudiant e1=	etudiantRepository.save(new Etudiant(null, "Ali", "Ben Ali", fdate.parse("10-03-2021"),f1,c1,null));
	Etudiant e2 =	etudiantRepository.save(new Etudiant(null, "Mohamed", "Ben Mohamed", fdate.parse("1-04-2010"),f1,c1,null));
	Etudiant e3 = etudiantRepository.save(new Etudiant(null, "Amin", "Ben Mahmoud", fdate.parse("19-07-2015"),f2,c1,null));
	Etudiant e4 = etudiantRepository.save(new Etudiant(null, "Samia", "Ben Ahmed", fdate.parse("26-10-2014"),f3,c1,null));
	Etudiant e5 =etudiantRepository.save(new Etudiant(null, "Foulen", "Ben Foulen1", fdate.parse("11-02-2018"),f3,c2,null));
	Etudiant e6 =etudiantRepository.save(new Etudiant(null, "Foulen", "Ben Foulen2", new Date(),f3,c3,null));

	//	ClasseMatiere(Long, Matiere, Classe, int, int)
		ClasseMatiere cl1 = new ClasseMatiere();
       
		//Matiere(Long, String, String, List<ClasseMatiere>, List<Abscence>)
		Matiere m = matiereRepository.save(new Matiere(null,"SOA","SOA",null,null));
		Matiere m1 = matiereRepository.save(new Matiere(null, "AFCP", "AFCP", null, null));

		// Create and save ClasseMatiere instances
		ClasseMatiere classeMat = new ClasseMatiere();
		classeMat.setCoef(2);
		classeMat.setNbrHs(6);
		classeMat.setClasse(c1);
		classeMat.setMatiere(m1);
		classeMatiereRepository.save(classeMat);

		ClasseMatiere classeMat1 = new ClasseMatiere();
		classeMat1.setCoef(2);
		classeMat1.setNbrHs(6);
		classeMat1.setClasse(c2);
		classeMat1.setMatiere(m1);
		classeMatiereRepository.save(classeMat1);

		ClasseMatiere classeMat2 = new ClasseMatiere();
		classeMat2.setCoef(2);
		classeMat2.setNbrHs(6);
		classeMat2.setClasse(c3);
		classeMat2.setMatiere(m1);
		classeMatiereRepository.save(classeMat2);

		// Create and save another set of ClasseMatiere instances
		ClasseMatiere classeMat3 = new ClasseMatiere();
		classeMat3.setCoef(2);
		classeMat3.setNbrHs(6);
		classeMat3.setClasse(c1);
		classeMat3.setMatiere(m);
		classeMatiereRepository.save(classeMat3);

		ClasseMatiere classeMat4 = new ClasseMatiere();
		classeMat4.setCoef(2);
		classeMat4.setNbrHs(6);
		classeMat4.setClasse(c2);
		classeMat4.setMatiere(m);
		classeMatiereRepository.save(classeMat4);

		ClasseMatiere classeMat5 = new ClasseMatiere();
		classeMat5.setCoef(2);
		classeMat5.setNbrHs(6);
		classeMat5.setClasse(c3);
		classeMat5.setMatiere(m);
		classeMatiereRepository.save(classeMat5);

		
		//Abscence(Long, Matiere, Etudiant, Date, float)
		Abscence a = abscenceRepository.save( new Abscence(null,m1,e1,new Date(),2.5F));
		Abscence a1 = abscenceRepository.save( new Abscence(null,m ,e1,new Date(),3.5F));
 
		
		
		


	}
}
