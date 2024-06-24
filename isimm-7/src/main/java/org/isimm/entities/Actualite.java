package org.isimm.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actualite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String liendrive;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getLiendrive() {
		return liendrive;
	}
	public void setLiendrive(String liendrive) {
		this.liendrive = liendrive;
	}
	public Actualite(String titre, String liendrive) {
		super();
		this.titre = titre;
		this.liendrive = liendrive;
	}
public Actualite() {}
}
