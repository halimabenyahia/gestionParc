package com.auth.entitie;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;


@Entity
public class Depense_Piece {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_depense_piece ;
	private int tva_dp ;
	private BigDecimal hors_taxe ;
	private Long ttc_dp ;
	private int qte ;
	
	@ManyToOne
	@JoinColumn(name="id_piece",nullable=false)
	private Piece piece_dep;
	
	
	@ManyToOne
	@JoinColumn(name="id_depense")
	private Depense depense_dep ;
	

	
	public int getId_depense_piece() {
		return id_depense_piece;
	}



	public void setId_depense_piece(int id_depense_piece) {
		this.id_depense_piece = id_depense_piece;
	}



	public int getTva_dp() {
		return tva_dp;
	}



	public void setTva_dp(int tva_dp) {
		this.tva_dp = tva_dp;
	}



	public BigDecimal getHors_taxe() {
		return hors_taxe;
	}



	public void setHors_taxe(BigDecimal hors_taxe) {
		this.hors_taxe = hors_taxe;
	}



	public Long getTtc_dp() {
		return ttc_dp;
	}



	public void setTtc_dp(Long ttc_dp) {
		this.ttc_dp = ttc_dp;
	}



	public int getQte() {
		return qte;
	}



	public void setQte(int qte) {
		this.qte = qte;
	}



	public Piece getPiece_dep() {
		return piece_dep;
	}



	public void setPiece_dep(Piece piece_dep) {
		this.piece_dep = piece_dep;
	}



	public Depense getDepense_dep() {
		return depense_dep;
	}



	public void setDepense_dep(Depense depense_dep) {
		this.depense_dep = depense_dep;
	}



	public Depense_Piece() {
		super();
		// TODO Auto-generated constructor stub
	}	

}
