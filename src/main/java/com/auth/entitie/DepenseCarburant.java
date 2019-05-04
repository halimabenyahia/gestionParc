package com.auth.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DepenseCarburant {
	
	@Id @GeneratedValue
	private int id_depenseCar ;
	private long nb_litre ;
	private String compteur_dc ;
	private String origine_carburant ;
	
	public int getId_depenseCar() {
		return id_depenseCar;
	}
	public void setId_depenseCar(int id_depenseCar) {
		this.id_depenseCar = id_depenseCar;
	}
	public long getNb_litre() {
		return nb_litre;
	}
	public void setNb_litre(long nb_litre) {
		this.nb_litre = nb_litre;
	}
	public String getCompteur_dc() {
		return compteur_dc;
	}
	public void setCompteur_dc(String compteur_dc) {
		this.compteur_dc = compteur_dc;
	}
	public String getOrigine_carburant() {
		return origine_carburant;
	}
	public void setOrigine_carburant(String origine_carburant) {
		this.origine_carburant = origine_carburant;
	}
	public DepenseCarburant(int id_depenseCar, long nb_litre, String compteur_dc, String origine_carburant) {
		super();
		this.id_depenseCar = id_depenseCar;
		this.nb_litre = nb_litre;
		this.compteur_dc = compteur_dc;
		this.origine_carburant = origine_carburant;
	}
	public DepenseCarburant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
