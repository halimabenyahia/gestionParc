package com.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.auth.entitie.SortieStock;

public interface SortieStockRepository extends JpaRepository<SortieStock, Integer> {
	
//	@Query("from SortieStock s where s.vehicule_sortie= '123tu1234' ")
//	public SortieStock findbyV();

}
