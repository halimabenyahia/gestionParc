package com.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.TypeEntretien;
import com.auth.entitie.TypePiece;

public interface TypeEntretienRepository extends JpaRepository<TypeEntretien, Integer> {
	
	@Query("select t from TypeEntretien t where t.des_typeEntretien like :parametre")
	public List<TypeEntretien> findByTypeEntretien(@Param("parametre") String parametre) ;

}
