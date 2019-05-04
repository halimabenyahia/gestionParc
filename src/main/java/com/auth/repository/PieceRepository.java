package com.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.auth.entitie.Piece;

public interface PieceRepository extends JpaRepository<Piece, Integer> {
	
	
//	@Query("from Piece p where p.type_piece_p = 1 ")
//	public Piece findbyTypeP();
//	
//	@Query("from Piece p where p.entre_stock = 1 ")
//	public Piece findByEntree();
//	
//	@Query("from Piece p where p.sortie_stock = 1 ")
//	public Piece findBySortie();

}
