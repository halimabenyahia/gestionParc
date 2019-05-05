package com.auth.entitie;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Modele {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_modele ;
	private String des_modele ;
	
	
	public int getId_modele() {
		return id_modele;
	}
	public void setId_modele(int id_modele) {
		this.id_modele = id_modele;
	}
	public String getDes_modele() {
		return des_modele;
	}
	public void setDes_modele(String des_modele) {
		this.des_modele = des_modele;
	}
	public Modele(int id_modele, String des_modele) {
		super();
		this.id_modele = id_modele;
		this.des_modele = des_modele;
	}
	public Modele() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
