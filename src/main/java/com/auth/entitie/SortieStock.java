package com.auth.entitie;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SortieStock {
	
	@Id @GeneratedValue
	private int id_sortieStock ;
	@Temporal(TemporalType.DATE)
	private Date date_sortie ;
	private String description_sortie ;
	
//	@OneToOne
//	@JoinColumn(name="id_immatriculation")
//	private Vehicule vehicule_sortie ;

	public int getId_sortieStock() {
		return id_sortieStock;
	}

	public void setId_sortieStock(int id_sortieStock) {
		this.id_sortieStock = id_sortieStock;
	}

	public Date getDate_sortie() {
		return date_sortie;
	}

	public void setDate_sortie(Date date_sortie) {
		this.date_sortie = date_sortie;
	}

	public String getDescription_sortie() {
		return description_sortie;
	}

	public void setDescription_sortie(String description_sortie) {
		this.description_sortie = description_sortie;
	}

//	public Vehicule getVehicule_sortie() {
//		return vehicule_sortie;
//	}
//
//	public void setVehicule_sortie(Vehicule vehicule_sortie) {
//		this.vehicule_sortie = vehicule_sortie;
//	}

	public SortieStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SortieStock(int id_sortieStock, Date date_sortie, String description_sortie, Vehicule vehicule_sortie) {
		super();
		this.id_sortieStock = id_sortieStock;
		this.date_sortie = date_sortie;
		this.description_sortie = description_sortie;
		//this.vehicule_sortie = vehicule_sortie;
	}
	
	

}
