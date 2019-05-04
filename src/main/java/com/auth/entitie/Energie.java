package com.auth.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Energie {

	
	@Id @GeneratedValue
	private int id_energie ;
	private String des_energie ;
	public int getId_energie() {
		return id_energie;
	}
	public void setId_energie(int id_energie) {
		this.id_energie = id_energie;
	}
	public String getDes_energie() {
		return des_energie;
	}
	public void setDes_energie(String des_energie) {
		this.des_energie = des_energie;
	}
	public Energie(int id_energie, String des_energie) {
		super();
		this.id_energie = id_energie;
		this.des_energie = des_energie;
	}
	public Energie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
