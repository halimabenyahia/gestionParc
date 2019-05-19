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
	public List<Depense> getbyImmatricul(@Param("parametre") String parametre);

	String q = "select SUM(dep.ttc) from Depense dep where MONTH(dep.date_depense) = :mois ";
	String matricule = " and dep.vehicule_dep.immatriculation  =:matricule";
	@Query(q + matricule)
	public Long getAllMonths(@PathVariable String matricule, @PathVariable int mois);
	
//	@Query("select SUM(d.ttc) from Depense d where d.vehicule_dep.immatriculation  =:param1 "
//			+ "and MONTH(d.date_depense) = :mois"
//			+ "and d.type_depense = :param2")
//	public Long findSumDepByType(@PathVariable String param1,@PathVariable int mois , @PathVariable String param2);

	@Query("select v from Depense v where v.type_depense like :parametre")
	public Depense getdepenseByTtype(@Param("parametre") String parametre);
 
}
