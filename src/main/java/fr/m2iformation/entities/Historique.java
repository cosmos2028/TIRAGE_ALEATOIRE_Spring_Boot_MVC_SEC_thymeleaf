package fr.m2iformation.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Historique 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHisto;
    private Integer choix1;
    private Integer choix2;
    private Integer choix3;
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime   dateTimeTirage;
    private Integer nombre_a_trouver;
    private Boolean trouver;
    @ManyToOne
	@JoinColumn(name="idEmp")
    private Employe employe;

}
