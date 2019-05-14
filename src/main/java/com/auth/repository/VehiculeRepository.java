package com.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {
	
//    @Query("from Vehicule v where v.depense_v = 1")
//    public Vehicule findByDepense();
	
	@Query("select v from Vehicule v where v.immatriculation like :chaine")
	public List<Vehicule> findByImmatriculation(@Param("chaine") String chaine);
	
	
	@Query("select v from Vehicule v where v.immatriculation like :chaine")
	public Vehicule findByImmV(@Param("chaine") String chaine);

    
}
