package com.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.Chauffeurs;

public interface ChauffeursRepository extends JpaRepository<Chauffeurs, Integer> {
	
	
	@Query("select m from Chauffeurs m where m.nom_ch like :parametre")
	public List<Chauffeurs> findByParametreChauffeur(@Param("parametre") String parametre) ;
	
	@Query("select m from Chauffeurs m where m.nom_ch like :parametre")
	public Chauffeurs findBynomChauffeur(@Param("parametre") String parametre) ;
	
	
//	@Query("select m from Chauffeurs m where m.matricule_ch like :parametre")
//	public List<Chauffeurs> findByMatricule(@Param("parametre") String parametre) ;
	
	@Query("select COUNT(c.matricule_ch) from Chauffeurs c ")
	public int nbChauffeur();

}
