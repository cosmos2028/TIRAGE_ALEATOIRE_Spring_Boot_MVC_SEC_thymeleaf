package fr.m2iformation.metier;

import java.util.List;

import fr.m2iformation.entities.Employe;

public interface IEmployeMetier 
{
	Employe saveEmploye(Employe employe);
	public List<Employe> listEmployes();
	

}
