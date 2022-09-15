package fr.m2iformation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.m2iformation.entities.Historique;

public interface IHistoriqueRepository extends JpaRepository<Historique, Integer>
{

}
