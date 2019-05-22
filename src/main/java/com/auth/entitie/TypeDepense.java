package com.auth.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeDepense {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_typeDepense ;
	private String designation_typeDep ;
	public int getId_typeDepense() {
		return id_typeDepense;
	}
	public void setId_typeDepense(int id_typeDepense) {
		this.id_typeDepense = id_typeDepense;
	}
	public String getDesignation_typeDep() {
		return designation_typeDep;
	}
	public void setDesignation_typeDep(String designation_typeDep) {
		this.designation_typeDep = designation_typeDep;
	}
	public TypeDepense(int id_typeDepense, String designation_typeDep) {
		super();
		this.id_typeDepense = id_typeDepense;
		this.designation_typeDep = designation_typeDep;
	}
	public TypeDepense() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
