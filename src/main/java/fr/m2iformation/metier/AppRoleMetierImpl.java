package fr.m2iformation.metier;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.m2iformation.entities.AppRole;
import fr.m2iformation.repositories.IAppRoleRepository;
import lombok.AllArgsConstructor;

@Service @ AllArgsConstructor
public class AppRoleMetierImpl implements IAppRoleMetier 
{
	IAppRoleRepository appRoleRepository;
	
	@Override
	public AppRole saveEmploye(AppRole role)
	{
		return appRoleRepository.save(role);
	}

	@Override
	public List<AppRole> listRoles() {
		return appRoleRepository.findAll();
	}
	
}