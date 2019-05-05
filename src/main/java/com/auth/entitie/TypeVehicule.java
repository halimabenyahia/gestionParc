package com.auth.entitie;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class TypeVehicule {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_typeVehicule ;
	private String des_typeVehicule ;
	

	public int getId_typeVehicule() {
		return id_typeVehicule;
	}

	public void setId_typeVehicule(int id_typeVehicule) {
		this.id_typeVehicule = id_typeVehicule;
	}

	public String getDes_typeVehicule() {
		return des_typeVehicule;
	}

	public void setDes_typeVehicule(String des_typeVehicule) {
		this.des_typeVehicule = des_typeVehicule;
	}

	

	

	public TypeVehicule(int id_typeVehicule, String des_typeVehicule, List<Vehicule> vehicule_t) {
		super();
		this.id_typeVehicule = id_typeVehicule;
		this.des_typeVehicule = des_typeVehicule;
	}

	public TypeVehicule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
}
