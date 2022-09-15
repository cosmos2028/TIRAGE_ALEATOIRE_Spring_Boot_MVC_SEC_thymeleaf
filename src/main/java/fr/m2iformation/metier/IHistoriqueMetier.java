package fr.m2iformation.metier;

import java.util.List;

import fr.m2iformation.entities.Historique;

public interface IHistoriqueMetier 
{
	Historique saveHistorique(Historique historique);
	public List<Historique> listHistorique();

}
