package fr.m2iformation.metier;

import java.util.List;

import fr.m2iformation.entities.Adresse;

public interface IAdresseMetier 
{
	Adresse saveEmploye(Adresse adresse);
	public List<Adresse> listAdresses();

}
