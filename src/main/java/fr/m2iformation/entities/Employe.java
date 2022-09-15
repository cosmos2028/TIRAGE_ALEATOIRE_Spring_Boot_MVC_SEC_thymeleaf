package fr.m2iformation.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//annotation JPA
@Entity
//annotation de lombock pour generer les getters/setters(@Data),contructeur sans ou avec paramettre(@NoArgsConstructor,@AllArgsConstructor)
@Data @AllArgsConstructor @NoArgsConstructor
public class Employe 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmp;
	private String nom;
	private String prenom;
	private String email;
	private String motDePasse;
	//@Temporal(TemporalType.DATE)
	private LocalDate dateDeNaiss;
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "idAdr")
	private Adresse adresse;
	
	//un employe peut avoir plusieurs role
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "employe_role")
	private List<AppRole> appRoles = new ArrayList<AppRole>();

}
