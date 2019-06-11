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

	/*search by energie*/
	@Query("select v from Vehicule v where v.energie_v.des_energie like :carburant")
	public List<Vehicule> findByCarburant(@Param("carburant") String carburant);
    
	/*search by affectation */
	@Query("select v from Vehicule v where v.affectation_vehicule.des_affectation like :affectation")
	public List<Vehicule> findByAffectation(@Param("affectation") String affectation);
	
	/*search by type de vehicule */
	@Query("select v from Vehicule v where v.type_vehicule.des_typeVehicule like :type")
	public List<Vehicule> findByTypeVehicule(@Param("type") String type);
	
	@Query("select COUNT(v.immatriculation) from Vehicule v ")
	public int getNombreVehicule();
	
	
	/*nbre de vehicule partner*/
	@Query("select COUNT(v.immatriculation) from Vehicule v where v.type_vehicule.des_typeVehicule = 'partner' ")
	public int getNombrePartner();
	
	/*nbre de vehicule camion*/
	@Query("select COUNT(v.immatriculation) from Vehicule v where v.type_vehicule.des_typeVehicule = 'camion' ")
	public int getNombreCamion();
	
	/*nbre de vehicule partner*/
	@Query("select COUNT(v.immatriculation) from Vehicule v where v.type_vehicule.des_typeVehicule = 'voiture' ")
	public int getNombreVoiture();
	
	@Query("select v from Vehicule v where v.immatriculation like :chaine")
	public List<Vehicule> getVignetteByImm(@Param("chaine") String chaine);
	
	@Query("select COUNT(v.immatriculation) from Vehicule v where v.energie_v.des_energie = 'essence sans plomb' ")
	public int getNombreEssence();
	
}
