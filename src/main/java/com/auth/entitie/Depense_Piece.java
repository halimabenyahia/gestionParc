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
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Depense_Piece {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_depense_piece ;
	private int tva_dp ;
	private BigDecimal hors_taxe ;
	private BigDecimal ttc_dp ;
	private int qte ;
	
	@OneToOne
	@JoinColumn(name="id_depense")
	private Depense depense_dp ;
	
	@JsonProperty("id_depense")
	private void unpackdepense_dp(Integer id_depense) {
	    this.depense_dp = new Depense();
	    depense_dp.setId_depense(id_depense);
	}
	
	
	@OneToOne
	@JoinColumn(name="id_piece")
	private Piece piece_dep ;
	
	@JsonProperty("id_piece")
	private void unpackpiece_dep(Integer id_piece) {
	    this.piece_dep = new Piece();
	    piece_dep.setId_piece(id_piece);
	}


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


	public BigDecimal getTtc_dp() {
		return ttc_dp;
	}


	public void setTtc_dp(BigDecimal ttc_dp) {
		this.ttc_dp = ttc_dp;
	}


	public int getQte() {
		return qte;
	}


	public void setQte(int qte) {
		this.qte = qte;
	}


	public Depense getDepense_dp() {
		return depense_dp;
	}


	public void setDepense_dp(Depense depense_dp) {
		this.depense_dp = depense_dp;
	}


	public Piece getPiece_dep() {
		return piece_dep;
	}


	public void setPiece_dep(Piece piece_dep) {
		this.piece_dep = piece_dep;
	}


	public Depense_Piece() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Depense_Piece(int id_depense_piece, int tva_dp, BigDecimal hors_taxe, BigDecimal ttc_dp, int qte,
			Depense depense_dp, Piece piece_dep) {
		super();
		this.id_depense_piece = id_depense_piece;
		this.tva_dp = tva_dp;
		this.hors_taxe = hors_taxe;
		this.ttc_dp = ttc_dp;
		this.qte = qte;
		this.depense_dp = depense_dp;
		this.piece_dep = piece_dep;
	}



}
