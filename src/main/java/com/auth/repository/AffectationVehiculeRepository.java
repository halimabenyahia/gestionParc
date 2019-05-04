package com.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.AffectationVehicule;

public interface AffectationVehiculeRepository extends JpaRepository<AffectationVehicule, Integer> {
	
	@Query("select m from AffectationVehicule m where m.des_affectation like :parametre")
	public List<AffectationVehicule> findByAffectationParam(@Param("parametre") String parametre) ;

}
