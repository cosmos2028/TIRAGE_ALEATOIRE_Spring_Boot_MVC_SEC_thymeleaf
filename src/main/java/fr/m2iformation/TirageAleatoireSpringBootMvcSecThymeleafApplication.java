package fr.m2iformation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.m2iformation.entities.Adresse;
import fr.m2iformation.entities.AppRole;
import fr.m2iformation.entities.Employe;
import fr.m2iformation.repositories.IAdresseRepository;
import fr.m2iformation.repositories.IAppRoleRepository;
import fr.m2iformation.repositories.IEmployeRepository;

@SpringBootApplication
public class TirageAleatoireSpringBootMvcSecThymeleafApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(TirageAleatoireSpringBootMvcSecThymeleafApplication.class, args);
	}

	//s' excecute à chaque fois qu'on lance l'application et insere des données en BDD
	//en params on inject ce dont on a besoin les interfaces qui extends JPARepository
	//@Bean :je le commente pour eviter d'inserer les données en BDD de nouveau
	CommandLineRunner commandLineRunner(IEmployeRepository employeRepository,
			IAdresseRepository adresseRepository,IAppRoleRepository appRoleRepository)
	{
		return args ->
		{
			//creation de l adresse
			Adresse adresse = new Adresse();
			adresse.setNomVoie("12 av de paris");
			adresse.setVille("paris");
			adresse.setCodePostal("75007");
			
			adresseRepository.save(adresse);
			//creation du role
			AppRole appRole = new  AppRole();
			appRole.setRoleName("visiteur");
			List<AppRole> appRoles= new ArrayList<AppRole>();
			appRoles.add(appRole);
			
			appRoleRepository.save(appRole);
			//creation de l'employe
			Employe employe = new Employe();
			employe.setNom("Manga");
			employe.setPrenom("David");
			employe.setDateDeNaiss(LocalDate.now());
			employe.setMotDePasse("1234");
			employe.setActive(true);
			employe.setEmail("davidManga@gmail.com");
			employe.setAdresse(adresse);
			employe.setAppRoles(appRoles);
			
			employeRepository.save(employe);
			
			//afficher l 'employe
			employeRepository.findAll().forEach(
					e->{
						System.out.print("\n\nNom: "+e.getNom()+"\t");
						System.out.print("preNom: "+e.getPrenom()+"\t");
						System.out.print("Email: "+e.getEmail()+"\t");
						System.out.print("Adresse: "+e.getAdresse()+"\t");
						System.out.print("DDN: "+e.getDateDeNaiss()+"\t");
						System.out.print(e.getIdEmp());
						System.out.print("Idemp: "+e.getNom());
						
					});
		};
	}
}
