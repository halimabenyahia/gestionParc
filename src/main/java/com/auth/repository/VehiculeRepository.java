package com.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {
	
//    @Query("from Vehicule v where v.depense_v = 1")
//    public Vehicule findByDepense();
	
	@Query("select v from Vehicule v where v.immatriculation like :chaine")
	public Vehicule findByImmatriculation(@Param("chaine") String chaine);
	
	
	
//  @Query("from Vehicule v where v.assurance_vehicule = 1")
//  public Vehicule findByAssurance();

//	@Query("from Vehicule v where v.type_vehicule = 1 ")
//	public Vehicule findvVehiculeBytypeVehicule();
//
//    @Query("from Vehicule v where v.type_boite = 2")
//    public Vehicule findVehiculeByTypeBoite();
 
//    @Query("from Vehicule v where v.affectation_vehicule = 1")
//    public Vehicule findByAffec();
 
//    @Query("from Vehicule v where v.marque_v = 2")
//    public Vehicule findByMarque();
//    
//    @Query("from Vehicule v where v.modele_v = 1 ")
//	public Vehicule findbyModele();
//    
//    @Query("from Vehicule v where v.chauffeur_v = 1 ")
//   	public Vehicule findBychauff();
//    

//    
//    @Query("from Vehicule v where v.prog_v = 1 ")
//    public Vehicule findbyProg();
    
}
