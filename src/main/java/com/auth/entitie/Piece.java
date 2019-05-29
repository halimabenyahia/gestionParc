package com.auth.entitie;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Piece {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_piece ;
	private String reference_piece ;
	private String des_piece ;
	private Long tva_p ;
	private Long prix_achat ; // PU
	private Long qte_p ;
	private Long remise_p ;
	private Long montant_hors_taxe ;
	private Long ttc_p ;
	
	@OneToOne
	@JoinColumn(name="id_typePiece")
	private TypePiece type_piece_p ;
	
	@JsonProperty("id_typePiece")
	private void unpackTypepiece(Integer id_typePiece) {
	    this.type_piece_p = new TypePiece();
	    type_piece_p.setId_typePiece(id_typePiece);
	}
	
	@ManyToOne
	@JoinColumn(name="id_entree")
	private EntreeStock entre_stock ;
	
	@ManyToOne
	@JoinColumn(name="id_sortieStock")
	private SortieStock sortie_stock ;
	
	@ManyToMany(mappedBy="pieces")
	private Set<Depense> depenses ;
	
//	@JsonProperty("id_depense")
//	private Set<Depense> unpackDepense(Integer id_depense) {
//	    this.depenses = new Depense();
//	    //depenses;
//	}

	public int getId_piece() {
		return id_piece;
	}

	public void setId_piece(int id_piece) {
		this.id_piece = id_piece;
	}

	public String getReference_piece() {
		return reference_piece;
	}

	public void setReference_piece(String reference_piece) {
		this.reference_piece = reference_piece;
	}

	public String getDes_piece() {
		return des_piece;
	}

	public void setDes_piece(String des_piece) {
		this.des_piece = des_piece;
	}

	public Long getTva_p() {
		return tva_p;
	}

	public void setTva_p(Long tva_p) {
		this.tva_p = tva_p;
	}

	public Long getPrix_achat() {
		return prix_achat;
	}

	public void setPrix_achat(Long prix_achat) {
		this.prix_achat = prix_achat;
	}

	public Long getQte_p() {
		return qte_p;
	}

	public void setQte_p(Long qte_p) {
		this.qte_p = qte_p;
	}

	public Long getRemise_p() {
		return remise_p;
	}

	public void setRemise_p(Long remise_p) {
		this.remise_p = remise_p;
	}

	public TypePiece getType_piece_p() {
		return type_piece_p;
	}

	public void setType_piece_p(TypePiece type_piece_p) {
		this.type_piece_p = type_piece_p;
	}

	public EntreeStock getEntre_stock() {
		return entre_stock;
	}

	public void setEntre_stock(EntreeStock entre_stock) {
		this.entre_stock = entre_stock;
	}

	public SortieStock getSortie_stock() {
		return sortie_stock;
	}

	public void setSortie_stock(SortieStock sortie_stock) {
		this.sortie_stock = sortie_stock;
	}

	public Set<Depense> getDepenses() {
		return depenses;
	}

	public void setDepenses(Set<Depense> depenses) {
		this.depenses = depenses;
	}
	
	public Long getMontant_hors_taxe() {
		return montant_hors_taxe;
	}

	public void setMontant_hors_taxe(Long montant_hors_taxe) {
		this.montant_hors_taxe = montant_hors_taxe;
	}

	public Long getTtc_p() {
		return ttc_p;
	}

	public void setTtc_p(Long ttc_p) {
		this.ttc_p = ttc_p;
	}

	public Piece(int id_piece, String reference_piece, String des_piece, Long tva_p, Long prix_achat, Long qte_p,
			Long remise_p, TypePiece type_piece_p, EntreeStock entre_stock, SortieStock sortie_stock,
			Set<Depense> depenses , Long montant_hors_taxe , Long ttc_p) {
		super();
		this.id_piece = id_piece;
		this.reference_piece = reference_piece;
		this.des_piece = des_piece;
		this.tva_p = tva_p;
		this.prix_achat = prix_achat;
		this.qte_p = qte_p;
		this.remise_p = remise_p;
		this.type_piece_p = type_piece_p;
		this.entre_stock = entre_stock;
		this.sortie_stock = sortie_stock;
		this.depenses = depenses;
		this.montant_hors_taxe = montant_hors_taxe ;
		this.ttc_p = ttc_p ;
	}

	public Piece() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
