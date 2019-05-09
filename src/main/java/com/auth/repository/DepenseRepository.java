package com.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.Depense;

public interface DepenseRepository extends JpaRepository<Depense, Integer> {
	
	@Query("select v from Depense v where v.vehicule_dep.immatriculation like :parametre")
	public List<Depense> getbyImmatricul(@Param("parametre") String parametre) ;
	
	
	@Query("select SUM(d.ttc) from Depense d "
			+ "where d.vehicule_dep.immatriculation "
			+ "like :parametre "
			+ "and MONTH(d.date_depense) = 01 "
			+ "and YEAR(d.date_depense)= '2018' ")
	public Long getSUM(@Param("parametre") String parametre);
	
//	@Query("from Depense d where d.vehicule_depense = '123tu1234' ")
//	public Depense findByidimm();
//
//	@Query("from Depense d where d.fournisseur_d = 1 ")
//	public Depense findbyfour();
//	
//	@Query("from Depense d where d.piece_d = 1 ")
//	public Depense findByPiece();
//	
//	@Query("from Depense d where d.depense_carburant = 1 ")
//	public Depense findbydepCar();

}
