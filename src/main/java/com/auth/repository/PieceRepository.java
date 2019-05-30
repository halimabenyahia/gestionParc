package com.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.Piece;

public interface PieceRepository extends JpaRepository<Piece, Integer> {
	
	
	@Query("select p from Piece p where p.des_piece  like :designation")
	public List<Piece> findbyDesPiece(@Param("designation") String designation);
	
	@Query("select SUM(p.ttc_p) from Piece p ")
	public Long getSumPiece();


}
