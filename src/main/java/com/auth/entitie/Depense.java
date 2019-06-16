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
	private String reference_d ;
	private String compteur_d ;
	private String description_depense ;
	private Long total_ttc ;
    private Long total_ht ;
    private Long montant_carburant ;
	
	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
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

	public String getDescription_depense() {
		return description_depense;
	}

	public void setDescription_depense(String description_depense) {
		this.description_depense = description_depense;
	}
	

	public Long getTotal_ttc() {
		return total_ttc;
	}

	public void setTotal_ttc(Long total_ttc) {
		this.total_ttc = total_ttc;
	}

	public Long getTotal_ht() {
		return total_ht;
	}

	public void setTotal_ht(Long total_ht) {
		this.total_ht = total_ht;
	}

	public Long getMontant_carburant() {
		return montant_carburant;
	}

	public void setMontant_carburant(Long montant_carburant) {
		this.montant_carburant = montant_carburant;
	}

	public Depense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Depense(int id_depense, Date date_depense, String reference_d, String compteur_d, String description_depense,
			Long total_ttc, Long total_ht, Vehicule vehicule_dep, TypeDepense typedepense , Long montant_carburant) {
		super();
		this.id_depense = id_depense;
		this.date_depense = date_depense;
		this.reference_d = reference_d;
		this.compteur_d = compteur_d;
		this.description_depense = description_depense;
		this.total_ttc = total_ttc;
		this.total_ht = total_ht;
		this.vehicule_dep = vehicule_dep;
		this.typedepense = typedepense;
		this.montant_carburant = montant_carburant;
	}


}
