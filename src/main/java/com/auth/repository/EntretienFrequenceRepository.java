package com.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.auth.entitie.EntretienFrequence;

public interface EntretienFrequenceRepository extends JpaRepository<EntretienFrequence, Integer> {
	
	
//	@Query("from EntretienFrequence f where f.programme_ent_freq = 1 ")
//	public EntretienFrequence findbyprogFreq() ;

}
