package fr.m2iformation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.m2iformation.entities.Adresse;

public interface IAdresseRepository extends JpaRepository<Adresse, Integer>
{

}
