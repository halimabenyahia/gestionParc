package com.auth.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Chauffeurs {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_chauffeur ;
	private String matricule_ch;
	private String nom_ch;
	private String prenom_ch ;
	private String adr_chauff;
	private String tel_chauff ;
	
	
	public int getId_chauffeur() {
		return id_chauffeur;
	}
	public void setId_chauffeur(int id_chauffeur) {
		this.id_chauffeur = id_chauffeur;
	}
	public String getMatricule_ch() {
		return matricule_ch;
	}
	public void setMatricule_ch(String matricule_ch) {
		this.matricule_ch = matricule_ch;
	}
	public String getNom_ch() {
		return nom_ch;
	}
	public void setNom_ch(String nom_ch) {
		this.nom_ch = nom_ch;
	}
	public String getPrenom_ch() {
		return prenom_ch;
	}
	public void setPrenom_ch(String prenom_ch) {
		this.prenom_ch = prenom_ch;
	}
	public String getAdr_chauff() {
		return adr_chauff;
	}
	public void setAdr_chauff(String adr_chauff) {
		this.adr_chauff = adr_chauff;
	}
	public String getTel_chauff() {
		return tel_chauff;
	}
	public void setTel_chauff(String tel_chauff) {
		this.tel_chauff = tel_chauff;
	}
	public Chauffeurs(String matricule_ch, String nom_ch, String prenom_ch, String adr_chauff, String tel_chauff) {
		super();
		this.matricule_ch = matricule_ch;
		this.nom_ch = nom_ch;
		this.prenom_ch = prenom_ch;
		this.adr_chauff = adr_chauff;
		this.tel_chauff = tel_chauff;
	}
	public Chauffeurs() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
