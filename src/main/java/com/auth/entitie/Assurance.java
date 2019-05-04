package com.auth.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Assurance {
	
	@Id @GeneratedValue
	private int id_assurance ;
	private String compagnie_ass ;
	private String adr_assurance ;
	private String tel_assurance ;
	public int getId_assurance() {
		return id_assurance;
	}
	public void setId_assurance(int id_assurance) {
		this.id_assurance = id_assurance;
	}
	public String getCompagnie_ass() {
		return compagnie_ass;
	}
	public void setCompagnie_ass(String compagnie_ass) {
		this.compagnie_ass = compagnie_ass;
	}
	public String getAdr_assurance() {
		return adr_assurance;
	}
	public void setAdr_assurance(String adr_assurance) {
		this.adr_assurance = adr_assurance;
	}
	public String getTel_assurance() {
		return tel_assurance;
	}
	public void setTel_assurance(String tel_assurance) {
		this.tel_assurance = tel_assurance;
	}
	public Assurance(int id_assurance, String compagnie_ass, String adr_assurance, String tel_assurance) {
		super();
		this.id_assurance = id_assurance;
		this.compagnie_ass = compagnie_ass;
		this.adr_assurance = adr_assurance;
		this.tel_assurance = tel_assurance;
	}
	public Assurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
