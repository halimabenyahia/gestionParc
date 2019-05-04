package com.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.TypeBoite;

public interface TypeBoiteRepository extends JpaRepository<TypeBoite, Integer> {

	
	@Query("select m from TypeBoite m where m.des_boite like :parametre")
	public List<TypeBoite> findByParametreBoite(@Param("parametre") String parametre) ;
}
