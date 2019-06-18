package com.auth.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.auth.entitie.Depense;
import com.auth.entitie.Depense_Piece;

public interface Depense_PieceRepository extends JpaRepository<Depense_Piece, Integer> {
	
//	@Query("select d from Depense_Piece d where d.piece_dep.id_piece = 7 ")
//	public Depense_Piece getBY() ;

	@Query("select dp.piece_dep.des_piece from Depense_Piece dp")
	public List<Depense_Piece> getListDepPiece();

	@Query("select SUM(d.hors_taxe) from Depense_Piece d ")
	public Long getTotalHT();
	
	
	@Query("select SUM(d.ttc_dp) from Depense_Piece d")
	public Long getTotalTTC();
	
	
	String q1 = "select SUM(dep.ttc_dp) from Depense_Piece dep where MONTH(dep.depense_dp.date_depense) = :mois ";
	String matricule1 = " and dep.depense_dp.vehicule_dep.immatriculation  =:matricule";
	@Query(q1 + matricule1)
	public Long getMonthPiece( @PathVariable String matricule ,@PathVariable int mois);
	
	
	
}
