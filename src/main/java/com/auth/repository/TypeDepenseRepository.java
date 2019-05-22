package com.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.auth.entitie.TypeDepense;


public interface TypeDepenseRepository extends JpaRepository<TypeDepense, Integer> {
	
	@Query("select t from TypeDepense t where t.designation_typeDep like :parametre")
	public List<TypeDepense> findByTypeDepenseParam(@Param("parametre") String parametre) ;

}
