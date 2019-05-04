package com.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.Modele;

public interface ModeleRepository extends JpaRepository<Modele, Integer> {
	
	@Query("select m from Modele m where m.des_modele like :parametre")
	public List<Modele> findByParamModel(@Param("parametre") String parametre) ;

}
