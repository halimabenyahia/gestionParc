package com.auth.entitie;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Depense {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_depense ;
	@Temporal(TemporalType.DATE)
	private Date date_depense ;
	private Long montant_ht ;
	private Long tva ;
	private Long ttc ;
//	private boolean mvt_caisse ;
	@Temporal(TemporalType.DATE)
	private Date date_caisse ;
	private String reference_d ;
	private String compteur_d ;
	
	@OneToOne
	@JoinColumn(name="id_vehicule")
	private Vehicule vehicule_dep ;
	
	@JsonProperty("id_vehicule")
	private void unpackVehicule(Integer id_vehicule) {
	    this.vehicule_dep = new Vehicule();
	    vehicule_dep.setId_vehicule(id_vehicule);
	}
	
	@OneToOne
	@JoinColumn(name="id_typeDepense")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private TypeDepense typedepense ;
	
	@JsonProperty("id_typeDepense")
	private void unpackTypeDep(Integer id_typeDepense) {
	    this.typedepense = new TypeDepense();
	    typedepense.setId_typeDepense(id_typeDepense);
	}
	
	@ManyToMany
	@JoinTable(name="Association",joinColumns= @JoinColumn(name="id_depense"),
	                inverseJoinColumns=@JoinColumn(name="id_piece"))
	Set<Piece> pieces = new HashSet<Piece>();

	public int getId_depense() {
		return id_depense;
	}

	public void setId_depense(int id_depense) {
		this.id_depense = id_depense;
	}

	public Date getDate_depense() {
		return date_depense;
	}

	public void setDate_depense(Date date_depense) {
		this.date_depense = date_depense;
	}

	public Long getMontant_ht() {
		return montant_ht;
	}

	public void setMontant_ht(Long montant_ht) {
		this.montant_ht = montant_ht;
	}

	public Long getTva() {
		return tva;
	}

	public void setTva(Long tva) {
		this.tva = tva;
	}

	public Long getTtc() {
		return ttc;
	}

	public void setTtc(Long ttc) {
		this.ttc = ttc;
	}


	public Date getDate_caisse() {
		return date_caisse;
	}

	public void setDate_caisse(Date date_caisse) {
		this.date_caisse = date_caisse;
	}

	public String getReference_d() {
		return reference_d;
	}

	public void setReference_d(String reference_d) {
		this.reference_d = reference_d;
	}

	public String getCompteur_d() {
		return compteur_d;
	}

	public void setCompteur_d(String compteur_d) {
		this.compteur_d = compteur_d;
	}


	public Vehicule getVehicule_dep() {
		return vehicule_dep;
	}

	public void setVehicule_dep(Vehicule vehicule_dep) {
		this.vehicule_dep = vehicule_dep;
	}	

	public TypeDepense getTypedepense() {
		return typedepense;
	}

	public void setTypedepense(TypeDepense typedepense) {
		this.typedepense = typedepense;
	}
	
	public Set<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(Set<Piece> pieces) {
		this.pieces = pieces;
	}
	
	

	public Depense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Depense(int id_depense, Date date_depense, Long montant_ht, Long tva, Long ttc, Date date_caisse,
			String reference_d, String compteur_d, Vehicule vehicule_dep, TypeDepense typedepense, Set<Piece> pieces) {
		super();
		this.id_depense = id_depense;
		this.date_depense = date_depense;
		this.montant_ht = montant_ht;
		this.tva = tva;
		this.ttc = ttc;
		this.date_caisse = date_caisse;
		this.reference_d = reference_d;
		this.compteur_d = compteur_d;
		this.vehicule_dep = vehicule_dep;
		this.typedepense = typedepense;
		this.pieces = pieces;
	}

}
