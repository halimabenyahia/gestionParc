package com.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.Assurance;

public interface AssuranceRepository extends JpaRepository<Assurance, Integer> {
	
	@Query("select m from Assurance m where m.compagnie_ass like :parametre")
	public List<Assurance> findByParametreAssurance(@Param("parametre") String parametre) ;

}
