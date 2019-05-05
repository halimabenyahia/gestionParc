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

@Entity
public class Depense {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_depense ;
	@Temporal(TemporalType.DATE)
	private Date date_depense ;
	private Long montant_ht ;
	private Long tva ;
	private Long ttc ;
	private boolean mvt_caisse ;
	@Temporal(TemporalType.DATE)
	private Date date_caisse ;
	private String reference_d ;
	//private 
	

	@ManyToOne
	@JoinColumn(name="id_fournisseur")
	private Fournisseur fournisseur_d ;
	
	@ManyToOne
	@JoinColumn(name="id_piece")
	private Piece piece_d ;
	
	@OneToOne
	@JoinColumn(name="id_depenseCar")
	private DepenseCarburant depense_carburant ;

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

	public Boolean getMvt_caisse() {
		return mvt_caisse;
	}

	public void setMvt_caisse(boolean mvt_caisse) {
		this.mvt_caisse = mvt_caisse;
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


	public Fournisseur getFournisseur_d() {
		return fournisseur_d;
	}

	public void setFournisseur_d(Fournisseur fournisseur_d) {
		this.fournisseur_d = fournisseur_d;
	}

	public Piece getPiece_d() {
		return piece_d;
	}

	public void setPiece_d(Piece piece_d) {
		this.piece_d = piece_d;
	}

	public DepenseCarburant getDepense_carburant() {
		return depense_carburant;
	}

	public void setDepense_carburant(DepenseCarburant depense_carburant) {
		this.depense_carburant = depense_carburant;
	}

	public Depense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Depense(int id_depense, Date date_depense, Long montant_ht, Long tva, Long ttc, boolean mvt_caisse,
			Date date_caisse, String reference_d, Fournisseur fournisseur_d, Piece piece_d,
			DepenseCarburant depense_carburant) {
		super();
		this.id_depense = id_depense;
		this.date_depense = date_depense;
		this.montant_ht = montant_ht;
		this.tva = tva;
		this.ttc = ttc;
		this.mvt_caisse = mvt_caisse;
		this.date_caisse = date_caisse;
		this.reference_d = reference_d;

		this.fournisseur_d = fournisseur_d;
		this.piece_d = piece_d;
		this.depense_carburant = depense_carburant;
	}

}
