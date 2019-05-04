package com.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.auth.entitie.EntretienPeriode;

public interface EntretienPeriodeRepository extends JpaRepository<EntretienPeriode, Integer> {
	
//	@Query ("from EntretienPeriode e where e.programme_ent_p = 1 ")
//	public EntretienPeriode findbyEntreP();

}
