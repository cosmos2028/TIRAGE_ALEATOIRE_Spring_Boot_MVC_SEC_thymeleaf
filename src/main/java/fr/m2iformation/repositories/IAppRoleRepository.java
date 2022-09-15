package fr.m2iformation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.m2iformation.entities.AppRole;

public interface IAppRoleRepository extends JpaRepository<AppRole, Integer>
{

}
