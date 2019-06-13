package com.auth.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.auth.entitie.Depense;
import com.auth.entitie.Depense_Piece;

public interface Depense_PieceRepository extends JpaRepository<Depense_Piece, Integer> {
	
//	@Query("select d from Depense_Piece d where d.piece_dep.id_piece = 7 ")
//	public Depense_Piece getBY() ;

	@Query("select dp.piece_dep.des_piece from Depense_Piece dp")
	public List<Depense_Piece> getListDepPiece();

	//public Depense_Piece save(Depense d, List<Depense_Piece> dp);
	
	
	
}
