package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.auth.entitie.AffectationVehicule;
import com.auth.entitie.Chauffeurs;
import com.test.TestParcRepository;

@SpringBootTest
public class AffectationTestRepository extends TestParcRepository {
	
	@Autowired
	AffectationVehiculeRepository affectationRep ;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		//System.out.println("--------------- Testing givenEntityRepository_whenSaving Method ---------------");
		AffectationVehicule savedAffectation=new AffectationVehicule() ;
		savedAffectation.setDes_affectation("transport agent");
		savedAffectation=affectationRep.save(savedAffectation);
		AffectationVehicule foundAffectation = affectationRep.findByAffectationVehicule(savedAffectation.getDes_affectation());
		assertNotNull(foundAffectation);
		assertEquals( foundAffectation.getId_affectation(), savedAffectation.getId_affectation());	
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		AffectationVehicule savedAffectation=new AffectationVehicule() ;
		savedAffectation.setDes_affectation("transport agent");
		savedAffectation = affectationRep.save(savedAffectation);
		savedAffectation.setDes_affectation("agent");
		savedAffectation = affectationRep.save(savedAffectation);
		AffectationVehicule foundAffectation = affectationRep.getOne(savedAffectation.getId_affectation());
		assertEquals(foundAffectation.getDes_affectation(), savedAffectation.getDes_affectation());
		
	}

	@Override
	public void givenEntityRepository_whenDeleting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		// TODO Auto-generated method stub
		
	}

}
