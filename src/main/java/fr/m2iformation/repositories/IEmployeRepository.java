package fr.m2iformation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.m2iformation.entities.Employe;

public interface IEmployeRepository extends JpaRepository<Employe, Integer> {

}
