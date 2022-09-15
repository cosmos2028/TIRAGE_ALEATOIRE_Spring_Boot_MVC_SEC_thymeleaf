package fr.m2iformation.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.m2iformation.entities.Adresse;
import fr.m2iformation.repositories.IAdresseRepository;
import lombok.AllArgsConstructor;

//@AllArgsConstructor permet de creer un constructeur avec paramettre en injectant la 
//la dependance adresseRepository au lieu d'utiliser @Autowired(mais c'est pareil)
@Service @AllArgsConstructor
public class AdresseMetierImpl implements IAdresseMetier 
{
	
	
	IAdresseRepository adresseRepository;
	
	@Override
	public Adresse saveEmploye(Adresse adresse) 
	{
		return adresseRepository.save(adresse);
	}

	@Override
	public List<Adresse> listAdresses() {
		return adresseRepository.findAll();
	}

}
