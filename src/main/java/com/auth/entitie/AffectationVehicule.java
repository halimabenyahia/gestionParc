package com.auth.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AffectationVehicule {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_affectation ;
	private String des_affectation ;
	
	public int getId_affectation() {
		return id_affectation;
	}
	public void setId_affectation(int id_affectation) {
		this.id_affectation = id_affectation;
	}
	public String getDes_affectation() {
		return des_affectation;
	}
	public void setDes_affectation(String des_affectation) {
		this.des_affectation = des_affectation;
	}
	public AffectationVehicule(int id_affectation, String des_affectation) {
		super();
		this.id_affectation = id_affectation;
		this.des_affectation = des_affectation;
	}
	public AffectationVehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
