package com.auth.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeEntretien {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_typeEntretien ;
	private String des_typeEntretien ;
	
	
	public int getId_typeEntretien() {
		return id_typeEntretien;
	}
	public void setId_typeEntretien(int id_typeEntretien) {
		this.id_typeEntretien = id_typeEntretien;
	}
	public String getDes_typeEntretien() {
		return des_typeEntretien;
	}
	public void setDes_typeEntretien(String des_typeEntretien) {
		this.des_typeEntretien = des_typeEntretien;
	}
	public TypeEntretien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeEntretien(int id_typeEntretien, String des_typeEntretien) {
		super();
		this.id_typeEntretien = id_typeEntretien;
		this.des_typeEntretien = des_typeEntretien;
	}
	
	
	
	
}
