package com.auth.entitie;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Vehicule {
	

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_vehicule;
	private String immatriculation ;
	@Temporal(TemporalType.DATE)
	private Date date_m_c ;
	@Temporal(TemporalType.DATE)
	private Date date_acq ;
	private Long cout_achat ;
	private Long compteur ;
	private String num_moteur ;
	private String num_fab ;
	@Temporal(TemporalType.DATE)
	private Date date_deb_taxe ;
	@Temporal(TemporalType.DATE)
	private Date date_fin_taxe ;
	private Long montant_taxe ;
	@Temporal(TemporalType.DATE)
	private Date date_deb_vig ;
	@Temporal(TemporalType.DATE)
	private Date date_fin_vig ;
	private Long montant_vig ;
	@Temporal(TemporalType.DATE)
	private Date date_deb_visit_tech ;
	@Temporal(TemporalType.DATE)
	private Date date_fin_visit_tech ;
	private Long montant_visit_tech ;
	@Temporal(TemporalType.DATE)
	private Date date_deb_contrat ;
	@Temporal(TemporalType.DATE)
	private Date date_fin_contrat ;
	private Long montant_contratAss ;
	
	
	@OneToOne
	@JoinColumn(name="id_typeVehicule")
	private TypeVehicule type_vehicule ;
	
	@OneToOne
	@JoinColumn(name="id_typeBoite")
    private TypeBoite type_boite ;
	
	@OneToOne
	@JoinColumn(name="id_energie")
	private Energie energie_v ;
	
	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="id_affectation")
	private AffectationVehicule affectation_vehicule ;
	

	
	@OneToOne
	@JoinColumn(name="id_marque")
	private Marque marque_v ;
	
	

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="id_chauffeur")
	private Chauffeurs chauffeur_v ;
	
	
	@OneToOne
	@JoinColumn(name="id_assurance")
	private Assurance assurance_vehicule ;
	
	
	@JsonProperty("id_chauffeur")
	private void unpackNested(Integer id_chauffeur) {
	    this.chauffeur_v = new Chauffeurs();
	    chauffeur_v.setId_chauffeur(id_chauffeur);
	}

	@JsonProperty("id_marque")
	private void unpackmarque(Integer id_marque) {
	    this.marque_v = new Marque();
	    marque_v.setId_marque(id_marque);;
	}
	
	
	@JsonProperty("id_typeBoite")
	private void unpacktypeBoite(Integer id_typeBoite) {
	    this.type_boite = new TypeBoite();
	    type_boite.setId_typeBoite(id_typeBoite);
	}
	
	@JsonProperty("id_energie")
	private void unpackenergie(Integer id_energie) {
	    this.energie_v = new Energie();
	    energie_v.setId_energie(id_energie);
	}
	
	@JsonProperty("id_assurance")
	private void unpackassurance(Integer id_assurance) {
	    this.assurance_vehicule = new Assurance();
	    assurance_vehicule.setId_assurance(id_assurance);
	}
	
	@JsonProperty("id_typeVehicule")
	private void unpacktypeVehicule(Integer id_typeVehicule) {
	    this.type_vehicule = new TypeVehicule();
	    type_vehicule.setId_typeVehicule(id_typeVehicule);
	}
	
	@JsonProperty("id_affectation")
	private void unpackaffectation(Integer id_affectation) {
	    this.affectation_vehicule = new AffectationVehicule();
	    affectation_vehicule.setId_affectation(id_affectation);
	}

	public int getId_vehicule() {
		return id_vehicule;
	}

	public void setId_vehicule(int id_vehicule) {
		this.id_vehicule = id_vehicule;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Date getDate_m_c() {
		return date_m_c;
	}

	public void setDate_m_c(Date date_m_c) {
		this.date_m_c = date_m_c;
	}

	public Date getDate_acq() {
		return date_acq;
	}

	public void setDate_acq(Date date_acq) {
		this.date_acq = date_acq;
	}

	public Long getCout_achat() {
		return cout_achat;
	}

	public void setCout_achat(Long cout_achat) {
		this.cout_achat = cout_achat;
	}

	public Long getCompteur() {
		return compteur;
	}

	public void setCompteur(Long compteur) {
		this.compteur = compteur;
	}

	public String getNum_moteur() {
		return num_moteur;
	}

	public void setNum_moteur(String num_moteur) {
		this.num_moteur = num_moteur;
	}

	public String getNum_fab() {
		return num_fab;
	}

	public void setNum_fab(String num_fab) {
		this.num_fab = num_fab;
	}

	public Date getDate_deb_taxe() {
		return date_deb_taxe;
	}

	public void setDate_deb_taxe(Date date_deb_taxe) {
		this.date_deb_taxe = date_deb_taxe;
	}

	public Date getDate_fin_taxe() {
		return date_fin_taxe;
	}

	public void setDate_fin_taxe(Date date_fin_taxe) {
		this.date_fin_taxe = date_fin_taxe;
	}

	public Long getMontant_taxe() {
		return montant_taxe;
	}

	public void setMontant_taxe(Long montant_taxe) {
		this.montant_taxe = montant_taxe;
	}

	public Date getDate_deb_vig() {
		return date_deb_vig;
	}

	public void setDate_deb_vig(Date date_deb_vig) {
		this.date_deb_vig = date_deb_vig;
	}

	public Date getDate_fin_vig() {
		return date_fin_vig;
	}

	public void setDate_fin_vig(Date date_fin_vig) {
		this.date_fin_vig = date_fin_vig;
	}

	public Long getMontant_vig() {
		return montant_vig;
	}

	public void setMontant_vig(Long montant_vig) {
		this.montant_vig = montant_vig;
	}

	public Date getDate_deb_visit_tech() {
		return date_deb_visit_tech;
	}

	public void setDate_deb_visit_tech(Date date_deb_visit_tech) {
		this.date_deb_visit_tech = date_deb_visit_tech;
	}

	public Date getDate_fin_visit_tech() {
		return date_fin_visit_tech;
	}

	public void setDate_fin_visit_tech(Date date_fin_visit_tech) {
		this.date_fin_visit_tech = date_fin_visit_tech;
	}

	public Long getMontant_visit_tech() {
		return montant_visit_tech;
	}

	public void setMontant_visit_tech(Long montant_visit_tech) {
		this.montant_visit_tech = montant_visit_tech;
	}

	public Date getDate_deb_contrat() {
		return date_deb_contrat;
	}

	public void setDate_deb_contrat(Date date_deb_contrat) {
		this.date_deb_contrat = date_deb_contrat;
	}

	public Date getDate_fin_contrat() {
		return date_fin_contrat;
	}

	public void setDate_fin_contrat(Date date_fin_contrat) {
		this.date_fin_contrat = date_fin_contrat;
	}

	public Long getMontant_contratAss() {
		return montant_contratAss;
	}

	public void setMontant_contratAss(Long montant_contratAss) {
		this.montant_contratAss = montant_contratAss;
	}

	public TypeVehicule getType_vehicule() {
		return type_vehicule;
	}

	public void setType_vehicule(TypeVehicule type_vehicule) {
		this.type_vehicule = type_vehicule;
	}

	public TypeBoite getType_boite() {
		return type_boite;
	}

	public void setType_boite(TypeBoite type_boite) {
		this.type_boite = type_boite;
	}

	public Energie getEnergie_v() {
		return energie_v;
	}

	public void setEnergie_v(Energie energie_v) {
		this.energie_v = energie_v;
	}

	public AffectationVehicule getAffectation_vehicule() {
		return affectation_vehicule;
	}

	public void setAffectation_vehicule(AffectationVehicule affectation_vehicule) {
		this.affectation_vehicule = affectation_vehicule;
	}

	public Marque getMarque_v() {
		return marque_v;
	}

	public void setMarque_v(Marque marque_v) {
		this.marque_v = marque_v;
	}

	public Chauffeurs getChauffeur_v() {
		return chauffeur_v;
	}

	public void setChauffeur_v(Chauffeurs chauffeur_v) {
		this.chauffeur_v = chauffeur_v;
	}

	public Assurance getAssurance_vehicule() {
		return assurance_vehicule;
	}

	public void setAssurance_vehicule(Assurance assurance_vehicule) {
		this.assurance_vehicule = assurance_vehicule;
	}


	public Vehicule(int id_vehicule, String immatriculation, Date date_m_c, Date date_acq, Long cout_achat,
			Long compteur, String num_moteur, String num_fab, Date date_deb_taxe, Date date_fin_taxe, Long montant_taxe,
			Date date_deb_vig, Date date_fin_vig, Long montant_vig, Date date_deb_visit_tech, Date date_fin_visit_tech,
			Long montant_visit_tech, Date date_deb_contrat, Date date_fin_contrat, Long montant_contratAss,
			TypeVehicule type_vehicule, TypeBoite type_boite, Energie energie_v,
			AffectationVehicule affectation_vehicule, Marque marque_v, Chauffeurs chauffeur_v,
			Assurance assurance_vehicule) {
		super();
		this.id_vehicule = id_vehicule;
		this.immatriculation = immatriculation;
		this.date_m_c = date_m_c;
		this.date_acq = date_acq;
		this.cout_achat = cout_achat;
		this.compteur = compteur;
		this.num_moteur = num_moteur;
		this.num_fab = num_fab;
		this.date_deb_taxe = date_deb_taxe;
		this.date_fin_taxe = date_fin_taxe;
		this.montant_taxe = montant_taxe;
		this.date_deb_vig = date_deb_vig;
		this.date_fin_vig = date_fin_vig;
		this.montant_vig = montant_vig;
		this.date_deb_visit_tech = date_deb_visit_tech;
		this.date_fin_visit_tech = date_fin_visit_tech;
		this.montant_visit_tech = montant_visit_tech;
		this.date_deb_contrat = date_deb_contrat;
		this.date_fin_contrat = date_fin_contrat;
		this.montant_contratAss = montant_contratAss;
		this.type_vehicule = type_vehicule;
		this.type_boite = type_boite;
		this.energie_v = energie_v;
		this.affectation_vehicule = affectation_vehicule;
		this.marque_v = marque_v;
		this.chauffeur_v = chauffeur_v;
		this.assurance_vehicule = assurance_vehicule;
	}

	public Vehicule() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
