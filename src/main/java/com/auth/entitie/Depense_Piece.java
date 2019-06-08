package com.auth.entitie;


public class Depense_Piece {
	
	private int id_depense ;
	private int id_piece ;
	private int tva_dp ;
	private Long hors_taxe ;
	private Long ttc_dp ;
	private int qte ;
	public int getId_depense() {
		return id_depense;
	}
	public void setId_depense(int id_depense) {
		this.id_depense = id_depense;
	}
	public int getId_piece() {
		return id_piece;
	}
	public void setId_piece(int id_piece) {
		this.id_piece = id_piece;
	}
	public int getTva_dp() {
		return tva_dp;
	}
	public void setTva_dp(int tva_dp) {
		this.tva_dp = tva_dp;
	}
	public Long getHors_taxe() {
		return hors_taxe;
	}
	public void setHors_taxe(Long hors_taxe) {
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
	public Depense_Piece(int id_depense, int id_piece, int tva_dp, Long hors_taxe, Long ttc_dp, int qte) {
		super();
		this.id_depense = id_depense;
		this.id_piece = id_piece;
		this.tva_dp = tva_dp;
		this.hors_taxe = hors_taxe;
		this.ttc_dp = ttc_dp;
		this.qte = qte;
	}
	public Depense_Piece() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
