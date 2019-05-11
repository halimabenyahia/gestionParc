package com.auth.repository;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.auth.entitie.Depense;
import com.auth.entitie.DepenseResponse;
import com.auth.entitie.Vehicule;

public interface DepenseRepository extends JpaRepository<Depense, Integer> {
	
    
	
	@Query("select v from Depense v where v.vehicule_dep.immatriculation like :parametre")
	public List<Depense> getbyImmatricul(@Param("parametre") String parametre) ;
	
	
	
	String q="select SUM(dep.ttc) from Depense dep where MONTH(dep.date_depense) = :mois ";
	String matricule=" and dep.vehicule_dep.immatriculation  =:matricule";
	@Query(q+matricule) 	
       public  Long getJanvier(@PathVariable String matricule,@PathVariable int mois);
	
	
	
	
	
	@Query("select d.vehicule_dep.immatriculation ,SUM(d.ttc) from Depense d "
			+ "where MONTH(d.date_depense) = 01 "
			+ "group by d.vehicule_dep.immatriculation ")
	public Long getSUM();
	


}
