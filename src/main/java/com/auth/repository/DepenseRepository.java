package com.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.auth.entitie.Depense;
import com.auth.entitie.DepenseResponse;

public interface DepenseRepository extends JpaRepository<Depense, Integer> {

	@Query("select v from Depense v where v.vehicule_dep.immatriculation like :parametre")
	public List<Depense> getbyImmatricul(@Param("parametre") String parametre);
	
	@Query("select v from Depense v where v.description_depense like :parametre")
	public Depense getbyDescription(@Param("parametre") String parametre);

//	String q = "select SUM(dep.ttc) from Depense dep where MONTH(dep.date_depense) = :mois ";
//	String matricule = " and dep.vehicule_dep.immatriculation  =:matricule";
//	@Query(q + matricule)
//	public Long getAllMonths(@PathVariable String matricule, @PathVariable int mois);
//	
//	
//	String q1 = "select dep.ttc from Depense dep where MONTH(dep.date_depense) = :mois ";
//	String matricule1 = " and dep.vehicule_dep.immatriculation  =:matricule";
////	String t = " and dep.type_depense  =:type " ;
//	@Query(q1 + matricule1 )
//	public Long getAllMonthByType(@PathVariable String matricule, @PathVariable int mois);
//	
//	@Query("select SUM(d.ttc) from Depense d ")
//	public Long montantTotal();
	
	
	@Query("select d from Depense d ")
	public List<Depense> getDepenseMaster();
	
	@Query("select MAX(d.id_depense) from Depense d ")
	public int getMaxId_depense();
	
	
	String q = "select SUM(dep.montant_carburant) from Depense dep where MONTH(dep.date_depense) = :mois ";
	String matricule = " and dep.vehicule_dep.immatriculation  =:matricule";
	@Query(q + matricule)
	public Long getMonthCarburant( @PathVariable String matricule ,@PathVariable int mois);
//	
	
 
}
