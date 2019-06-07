package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.AffectationVehicule;
import com.auth.entitie.Chauffeurs;
import com.test.TestParcRepository;

@SpringBootTest
@Transactional
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
		savedAffectation.setDes_affectation("agent");
		savedAffectation = affectationRep.save(savedAffectation);
		savedAffectation.setDes_affectation("agenttss");
		savedAffectation = affectationRep.save(savedAffectation);
		AffectationVehicule foundAffectation = affectationRep.getOne(savedAffectation.getId_affectation());
		assertEquals(foundAffectation.getDes_affectation(), savedAffectation.getDes_affectation());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		AffectationVehicule  savedAffectation= new AffectationVehicule() ;
		savedAffectation.setDes_affectation("service client");
		savedAffectation = affectationRep.save(savedAffectation);
		affectationRep.delete(savedAffectation);
		AffectationVehicule foundAffectation = affectationRep.findByAffectationVehicule(savedAffectation.getDes_affectation());
		assertEquals(null, foundAffectation);
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		AffectationVehicule savedAffectation = new AffectationVehicule() ;
		savedAffectation.setDes_affectation("service");
		savedAffectation = affectationRep.save(savedAffectation);
		List<AffectationVehicule> list = affectationRep.findAll();
		assertEquals(1, list.size());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		AffectationVehicule savedAffectation = new AffectationVehicule();
		savedAffectation.setDes_affectation("service");
		savedAffectation = affectationRep.save(savedAffectation);
		savedAffectation.setDes_affectation("client");
		AffectationVehicule foundAffectation = affectationRep.getOne(savedAffectation.getId_affectation());
		assertEquals(foundAffectation.getId_affectation(), savedAffectation.getId_affectation());
		
		
	}


}
