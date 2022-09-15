package fr.m2iformation.metier;

import java.util.List;

import fr.m2iformation.entities.AppRole;

public interface IAppRoleMetier 
{
	AppRole saveEmploye(AppRole role);
	public List<AppRole> listRoles();

}
