package com.auth.entitie;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EntreeStock {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_entree ;
	@Temporal(TemporalType.DATE)
	private Date date_entree ;
	private String description_entree ;
	private Long qte_entree ;
	public int getId_entree() {
		return id_entree;
	}
	public void setId_entree(int id_entree) {
		this.id_entree = id_entree;
	}
	public Date getDate_entree() {
		return date_entree;
	}
	public void setDate_entree(Date date_entree) {
		this.date_entree = date_entree;
	}
	public String getDescription_entree() {
		return description_entree;
	}
	public void setDescription_entree(String description_entree) {
		this.description_entree = description_entree;
	}
	public Long getQte_entree() {
		return qte_entree;
	}
	public void setQte_entree(Long qte_entree) {
		this.qte_entree = qte_entree;
	}
	public EntreeStock(int id_entree, Date date_entree, String description_entree, Long qte_entree) {
		super();
		this.id_entree = id_entree;
		this.date_entree = date_entree;
		this.description_entree = description_entree;
		this.qte_entree = qte_entree;
	}
	public EntreeStock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
