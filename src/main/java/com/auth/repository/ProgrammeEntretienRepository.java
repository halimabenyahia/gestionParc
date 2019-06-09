package com.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.Energie;
import com.auth.entitie.ProgrammeEntretien;

public interface ProgrammeEntretienRepository extends JpaRepository<ProgrammeEntretien, Integer> {
	
//	@Query("from ProgrammeEntretien p where p.vehicule_entretien= '123tu1234' ")
//	public ProgrammeEntretien findbyVehicule();
	
//	@Query("from ProgrammeEntretien p where p.type_entretien = 1 ")
//	public ProgrammeEntretien findbyTypeEntr() ;
	
	@Query("select m from ProgrammeEntretien m where m.description like :parametre")
	public ProgrammeEntretien findByDescription(@Param("parametre") String parametre) ;

}
