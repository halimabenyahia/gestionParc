package com.auth.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeBoite {
	
	
	@Id@GeneratedValue
	private int id_typeBoite ;
	private String des_boite ;
	public int getId_typeBoite() {
		return id_typeBoite;
	}
	public void setId_typeBoite(int id_typeBoite) {
		this.id_typeBoite = id_typeBoite;
	}
	public String getDes_boite() {
		return des_boite;
	}
	public void setDes_boite(String des_boite) {
		this.des_boite = des_boite;
	}
	public TypeBoite(int id_typeBoite, String des_boite) {
		super();
		this.id_typeBoite = id_typeBoite;
		this.des_boite = des_boite;
	}
	public TypeBoite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
