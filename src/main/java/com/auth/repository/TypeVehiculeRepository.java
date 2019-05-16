package com.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.TypeVehicule;

public interface TypeVehiculeRepository extends JpaRepository<TypeVehicule, Integer> {
	
	@Query("select m from TypeVehicule m where m.des_typeVehicule like :parametre")
	public List<TypeVehicule> findByTypeVehiculeParam(@Param("parametre") String parametre) ;
	
	@Query("select m from TypeVehicule m where m.des_typeVehicule like :parametre")
	public TypeVehicule findByTypeVehicule(@Param("parametre") String parametre) ;

}
