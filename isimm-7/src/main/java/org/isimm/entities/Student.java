package org.isimm.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student implements Serializable {
	//info personnels
	/************************************************************************************************************************************/
	@Id
	private Long CIN;
	@Column(length=100)
	private String nom;
	@Column(length=100)
	private String prenom;
	@Column(length=100)
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date naissance;
	@Column(length=100)
	private String sexe;
	@Column(length=100)
	private String nationalite;
	@Column(length=100)
	private String etatcivil;
	@Column(length=100)
	private String adresse;
	@Column(length=100)
	private Long numtel;
	@Column(length=100)
	private String email;
	@Column(length=100)
	//info etude
	/*****************************************************************************************************************************/
	private String cycle;
	@Column(length=100)
	private String specialite;
	@Column(length=100)
	private Long niveauEtude;
	@Column(length=100)
	private Long groupeTD;
	@Column(length=100)
	private Long groupeTP;
	@Column(length=100)
	private String Situation;
	@Column(length=100)
	private String EtablissementPrecedent;
	//info bac
	/**************************************************************************************************************************/
	@Column(length=100)
	private Long annebac;
	@Column(length=100)
	private String sectionbac;
	@Column(length=100)
	private String sessionbac;
	@Column(length=100)
	private String mentionbac;
	@Column(length=100)
	private Float moybac;
	@Column(length=100)
	private String paysbac;
	//info parent
	/*******************************************************************************************************************************/
	@Column(length=100)
	private String nompere;
	@Column(length=100)
	private String prenompere;
	@Column(length=100)
	private String nommere;
	@Column(length=100)
	private String prenommere;
	@Column(length=100)
	private String addresseparent;
	@Column(length=100)
	private Long numtelparent;
	public Long getCIN() {
		return CIN;
	}
	public void setCIN(Long cIN) {
		CIN = cIN;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getNaissance() {
		return naissance;
	}
	//@DateTimeFormat(pattern="dd/MM/yyyy")
	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getEtatcivil() {
		return etatcivil;
	}
	public void setEtatcivil(String etatcivil) {
		this.etatcivil = etatcivil;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Long getNumtel() {
		return numtel;
	}
	public void setNumtel(Long numtel) {
		this.numtel = numtel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public Long getNiveauEtude() {
		return niveauEtude;
	}
	public void setNiveauEtude(Long niveauEtude) {
		this.niveauEtude = niveauEtude;
	}
	public Long getGroupeTD() {
		return groupeTD;
	}
	public void setGroupeTD(Long groupeTD) {
		this.groupeTD = groupeTD;
	}
	public Long getGroupeTP() {
		return groupeTP;
	}
	public void setGroupeTP(Long groupeTP) {
		this.groupeTP = groupeTP;
	}
	public String getSituation() {
		return Situation;
	}
	public void setSituation(String situation) {
		Situation = situation;
	}
	public String getEtablissementPrecedent() {
		return EtablissementPrecedent;
	}
	public void setEtablissementPrecedent(String etablissementPrecedent) {
		EtablissementPrecedent = etablissementPrecedent;
	}
	public Long getAnnebac() {
		return annebac;
	}
	public void setAnnebac(Long annebac) {
		this.annebac = annebac;
	}
	public String getSectionbac() {
		return sectionbac;
	}
	public void setSectionbac(String sectionbac) {
		this.sectionbac = sectionbac;
	}
	public String getSessionbac() {
		return sessionbac;
	}
	public void setSessionbac(String sessionbac) {
		this.sessionbac = sessionbac;
	}
	public String getMentionbac() {
		return mentionbac;
	}
	public void setMentionbac(String mentionbac) {
		this.mentionbac = mentionbac;
	}
	public Float getMoybac() {
		return moybac;
	}
	public void setMoybac(Float moybac) {
		this.moybac = moybac;
	}
	public String getPaysbac() {
		return paysbac;
	}
	public void setPaysbac(String paysbac) {
		this.paysbac = paysbac;
	}
	public String getNompere() {
		return nompere;
	}
	public void setNompere(String nompere) {
		this.nompere = nompere;
	}
	public String getPrenompere() {
		return prenompere;
	}
	public void setPrenompere(String prenompere) {
		this.prenompere = prenompere;
	}
	public String getNommere() {
		return nommere;
	}
	public void setNommere(String nommere) {
		this.nommere = nommere;
	}
	public String getPrenommere() {
		return prenommere;
	}
	public void setPrenommere(String prenommere) {
		this.prenommere = prenommere;
	}
	public String getAddresseparent() {
		return addresseparent;
	}
	public void setAddresseparent(String addresseparent) {
		this.addresseparent = addresseparent;
	}
	public Long getNumtelparent() {
		return numtelparent;
	}
	public void setNumtelparent(Long numtelparent) {
		this.numtelparent = numtelparent;
	}
	public Student() {super();}
	public Student(Long cIN, String nom, String prenom, Date naissance, String sexe, String nationalite,
			String etatcivil, String adresse, Long numtel, String email, String cycle, String specialite,
			Long niveauEtude, Long groupeTD, Long groupeTP, String situation, String etablissementPrecedent,
			Long annebac, String sectionbac, String sessionbac, String mentionbac, Float moybac, String paysbac,
			String nompere, String prenompere, String nommere, String prenommere, String addresseparent,
			Long numtelparent) {
		CIN = cIN;
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.sexe = sexe;
		this.nationalite = nationalite;
		this.etatcivil = etatcivil;
		this.adresse = adresse;
		this.numtel = numtel;
		this.email = email;
		this.cycle = cycle;
		this.specialite = specialite;
		this.niveauEtude = niveauEtude;
		this.groupeTD = groupeTD;
		this.groupeTP = groupeTP;
		Situation = situation;
		EtablissementPrecedent = etablissementPrecedent;
		this.annebac = annebac;
		this.sectionbac = sectionbac;
		this.sessionbac = sessionbac;
		this.mentionbac = mentionbac;
		this.moybac = moybac;
		this.paysbac = paysbac;
		this.nompere = nompere;
		this.prenompere = prenompere;
		this.nommere = nommere;
		this.prenommere = prenommere;
		this.addresseparent = addresseparent;
		this.numtelparent = numtelparent;
	}
	
	
	@OneToOne
	private Account account;

	


	public void setAccount(Account account) {
	this.account=account;
		
	}
}
