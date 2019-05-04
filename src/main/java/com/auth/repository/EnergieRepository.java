package com.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.Energie;

public interface EnergieRepository extends JpaRepository<Energie, Integer> {

	
	@Query("select m from Energie m where m.des_energie like :parametre")
	public List<Energie> findByParametreEnergie(@Param("parametre") String parametre) ;
}
