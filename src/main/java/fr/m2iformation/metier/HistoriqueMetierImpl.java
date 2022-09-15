package fr.m2iformation.metier;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.m2iformation.entities.Historique;
import fr.m2iformation.repositories.IHistoriqueRepository;
import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class HistoriqueMetierImpl implements IHistoriqueMetier 
{

	IHistoriqueRepository historiqueRepository;
	
	@Override
	public Historique saveHistorique(Historique historique) 
	{
		return historiqueRepository.save(historique);
	}

	@Override
	public List<Historique> listHistorique() {
		return historiqueRepository.findAll();
	}

}
