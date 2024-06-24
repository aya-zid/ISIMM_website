package org.isimm.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class EmploiIngInfo1 implements Serializable{
private static final long serialVersionUID = 1L;
    
    @Id
    private Long id = 1L;
	private String lundi1;
	private String lundi2;
	private String lundi3;
	private String lundi4;
	private String lundi5;

	private String mardi1;
	private String mardi2;
	private String mardi3;
	private String mardi4;
	private String mardi5;

	private String mercredi1;
	private String mercredi2;
	private String mercredi3;
	private String mercredi4;
	private String mercredi5;

	private String jeudi1;
	private String jeudi2;
	private String jeudi3;
	private String jeudi4;
	private String jeudi5;

	private String vendredi1;
	private String vendredi2;
	private String vendredi3;
	private String vendredi4;
	private String vendredi5;

	private String samedi1;
	private String samedi2;
	private String samedi3;
	private String samedi4;
	private String samedi5;
	public String getLundi1() {
		return lundi1;
	}
	public void setLundi1(String lundi1) {
		this.lundi1 = lundi1;
	}
	public String getLundi2() {
		return lundi2;
	}
	public void setLundi2(String lundi2) {
		this.lundi2 = lundi2;
	}
	public String getLundi3() {
		return lundi3;
	}
	public void setLundi3(String lundi3) {
		this.lundi3 = lundi3;
	}
	public String getLundi4() {
		return lundi4;
	}
	public void setLundi4(String lundi4) {
		this.lundi4 = lundi4;
	}
	public String getLundi5() {
		return lundi5;
	}
	public void setLundi5(String lundi5) {
		this.lundi5 = lundi5;
	}
	public String getMardi1() {
		return mardi1;
	}
	public void setMardi1(String mardi1) {
		this.mardi1 = mardi1;
	}
	public String getMardi2() {
		return mardi2;
	}
	public void setMardi2(String mardi2) {
		this.mardi2 = mardi2;
	}
	public String getMardi3() {
		return mardi3;
	}
	public void setMardi3(String mardi3) {
		this.mardi3 = mardi3;
	}
	public String getMardi4() {
		return mardi4;
	}
	public void setMardi4(String mardi4) {
		this.mardi4 = mardi4;
	}
	public String getMardi5() {
		return mardi5;
	}
	public void setMardi5(String mardi5) {
		this.mardi5 = mardi5;
	}
	public String getMercredi1() {
		return mercredi1;
	}
	public void setMercredi1(String mercredi1) {
		this.mercredi1 = mercredi1;
	}
	public String getMercredi2() {
		return mercredi2;
	}
	public void setMercredi2(String mercredi2) {
		this.mercredi2 = mercredi2;
	}
	public String getMercredi3() {
		return mercredi3;
	}
	public void setMercredi3(String mercredi3) {
		this.mercredi3 = mercredi3;
	}
	public String getMercredi4() {
		return mercredi4;
	}
	public void setMercredi4(String mercredi4) {
		this.mercredi4 = mercredi4;
	}
	public String getMercredi5() {
		return mercredi5;
	}
	public void setMercredi5(String mercredi5) {
		this.mercredi5 = mercredi5;
	}
	public String getJeudi1() {
		return jeudi1;
	}
	public void setJeudi1(String jeudi1) {
		this.jeudi1 = jeudi1;
	}
	public String getJeudi2() {
		return jeudi2;
	}
	public void setJeudi2(String jeudi2) {
		this.jeudi2 = jeudi2;
	}
	public String getJeudi3() {
		return jeudi3;
	}
	public void setJeudi3(String jeudi3) {
		this.jeudi3 = jeudi3;
	}
	public String getJeudi4() {
		return jeudi4;
	}
	public void setJeudi4(String jeudi4) {
		this.jeudi4 = jeudi4;
	}
	public String getJeudi5() {
		return jeudi5;
	}
	public void setJeudi5(String jeudi5) {
		this.jeudi5 = jeudi5;
	}
	public String getVendredi1() {
		return vendredi1;
	}
	public void setVendredi1(String vendredi1) {
		this.vendredi1 = vendredi1;
	}
	public String getVendredi2() {
		return vendredi2;
	}
	public void setVendredi2(String vendredi2) {
		this.vendredi2 = vendredi2;
	}
	public String getVendredi3() {
		return vendredi3;
	}
	public void setVendredi3(String vendredi3) {
		this.vendredi3 = vendredi3;
	}
	public String getVendredi4() {
		return vendredi4;
	}
	public void setVendredi4(String vendredi4) {
		this.vendredi4 = vendredi4;
	}
	public String getVendredi5() {
		return vendredi5;
	}
	public void setVendredi5(String vendredi5) {
		this.vendredi5 = vendredi5;
	}
	public String getSamedi1() {
		return samedi1;
	}
	public void setSamedi1(String samedi1) {
		this.samedi1 = samedi1;
	}
	public String getSamedi2() {
		return samedi2;
	}
	public void setSamedi2(String samedi2) {
		this.samedi2 = samedi2;
	}
	public String getSamedi3() {
		return samedi3;
	}
	public void setSamedi3(String samedi3) {
		this.samedi3 = samedi3;
	}
	public String getSamedi4() {
		return samedi4;
	}
	public void setSamedi4(String samedi4) {
		this.samedi4 = samedi4;
	}
	public String getSamedi5() {
		return samedi5;
	}
	public void setSamedi5(String samedi5) {
		this.samedi5 = samedi5;
	}
	public EmploiIngInfo1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmploiIngInfo1(String lundi1, String lundi2, String lundi3, String lundi4, String lundi5, String mardi1,
			String mardi2, String mardi3, String mardi4, String mardi5, String mercredi1, String mercredi2,
			String mercredi3, String mercredi4, String mercredi5, String jeudi1, String jeudi2, String jeudi3,
			String jeudi4, String jeudi5, String vendredi1, String vendredi2, String vendredi3, String vendredi4,
			String vendredi5, String samedi1, String samedi2, String samedi3, String samedi4, String samedi5) {
		super();
		this.lundi1 = lundi1;
		this.lundi2 = lundi2;
		this.lundi3 = lundi3;
		this.lundi4 = lundi4;
		this.lundi5 = lundi5;
		this.mardi1 = mardi1;
		this.mardi2 = mardi2;
		this.mardi3 = mardi3;
		this.mardi4 = mardi4;
		this.mardi5 = mardi5;
		this.mercredi1 = mercredi1;
		this.mercredi2 = mercredi2;
		this.mercredi3 = mercredi3;
		this.mercredi4 = mercredi4;
		this.mercredi5 = mercredi5;
		this.jeudi1 = jeudi1;
		this.jeudi2 = jeudi2;
		this.jeudi3 = jeudi3;
		this.jeudi4 = jeudi4;
		this.jeudi5 = jeudi5;
		this.vendredi1 = vendredi1;
		this.vendredi2 = vendredi2;
		this.vendredi3 = vendredi3;
		this.vendredi4 = vendredi4;
		this.vendredi5 = vendredi5;
		this.samedi1 = samedi1;
		this.samedi2 = samedi2;
		this.samedi3 = samedi3;
		this.samedi4 = samedi4;
		this.samedi5 = samedi5;
	}
	public Long getId() {
        return id;
    }

}
