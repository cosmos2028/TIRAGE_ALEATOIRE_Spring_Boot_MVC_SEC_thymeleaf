package fr.m2iformation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2iformation.entities.Employe;
import fr.m2iformation.repositories.IEmployeRepository;

/*
 * @Service ou @Component permet de signaler au conteneur Spring qu'on va
 * utiliser les composants de Spring et toujours utilise dans la couche metier
 * 
 * permet de considerer la class comme un Bean Spring
 * 
 *  
 *  @autowire  est une annotation Spring qui permet d'injecter
 * une instance d'objet ou implementation de l'interface dans la varaible indique
 */
@Service
public class EmployeMetierImpl implements IEmployeMetier 
{
	/*
	 * @Autowired
	 * permet d'inject une implementation de cette interface
	 */
	@Autowired
	IEmployeRepository employeRepository;

	@Override
	public Employe saveEmploye(Employe employe) 
	{
		return employeRepository.save(employe);
	}

	@Override
	public List<Employe> listEmployes() 
	{
		return employeRepository.findAll();
	}

}
