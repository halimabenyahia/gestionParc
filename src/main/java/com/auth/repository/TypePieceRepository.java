package com.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.TypePiece;

public interface TypePieceRepository extends JpaRepository<TypePiece, Integer> {
	
	@Query("select t from TypePiece t where t.des_typePiece like :parametre")
	public List<TypePiece> findByTypePieceParam(@Param("parametre") String parametre) ;

	
	@Query("select t from TypePiece t where t.des_typePiece like :parametre")
	public TypePiece findByTypePiece(@Param("parametre") String parametre) ;
}
