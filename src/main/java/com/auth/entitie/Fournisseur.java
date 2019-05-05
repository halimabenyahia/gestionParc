package com.auth.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fournisseur {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_fournisseur ;
	private String raisonSocial ;
	private String tel_fournisseur ;
	private String adr_fournisseur ;
	private String fax_fournisseur ;
	private String mail_fournisseur ;
	private String responsable ;
	public int getId_fournisseur() {
		return id_fournisseur;
	}
	public void setId_fournisseur(int id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
	}
	public String getRaisonSocial() {
		return raisonSocial;
	}
	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}
	public String getTel_fournisseur() {
		return tel_fournisseur;
	}
	public void setTel_fournisseur(String tel_fournisseur) {
		this.tel_fournisseur = tel_fournisseur;
	}
	public String getAdr_fournisseur() {
		return adr_fournisseur;
	}
	public void setAdr_fournisseur(String adr_fournisseur) {
		this.adr_fournisseur = adr_fournisseur;
	}
	public String getFax_fournisseur() {
		return fax_fournisseur;
	}
	public void setFax_fournisseur(String fax_fournisseur) {
		this.fax_fournisseur = fax_fournisseur;
	}
	public String getMail_fournisseur() {
		return mail_fournisseur;
	}
	public void setMail_fournisseur(String mail_fournisseur) {
		this.mail_fournisseur = mail_fournisseur;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(int id_fournisseur, String raisonSocial, String tel_fournisseur, String adr_fournisseur,
			String fax_fournisseur, String mail_fournisseur, String responsable) {
		super();
		this.id_fournisseur = id_fournisseur;
		this.raisonSocial = raisonSocial;
		this.tel_fournisseur = tel_fournisseur;
		this.adr_fournisseur = adr_fournisseur;
		this.fax_fournisseur = fax_fournisseur;
		this.mail_fournisseur = mail_fournisseur;
		this.responsable = responsable;
	}
	
	

}
