package com.auth.entitie;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Modele {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_modele ;
	private String des_modele ;
	
//	@OneToOne
//	@JoinColumn(name="id_marque")
//	private Marque marque_m ;
//	
//	@JsonProperty("id_marque")
//	private void unpackmarque(Integer id_marque) {
//	    this.marque_m = new Marque();
//	    marque_m.setId_marque(id_marque);
//	}
	
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
	
	
//	public Marque getMarque_m() {
//		return marque_m;
//	}
//	public void setMarque_m(Marque marque_m) {
//		this.marque_m = marque_m;
//	}
	public Modele(int id_modele, String des_modele , Marque marque_m) {
		super();
		this.id_modele = id_modele;
		this.des_modele = des_modele;
		//this.marque_m = marque_m ;
	}
	public Modele() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
