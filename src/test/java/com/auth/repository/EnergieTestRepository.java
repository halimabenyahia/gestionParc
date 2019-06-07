package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.Assurance;
import com.auth.entitie.Energie;

import com.test.TestParcRepository;

@SpringBootTest
@Transactional
public class EnergieTestRepository extends TestParcRepository {
	
	@Autowired
	EnergieRepository energieRep ;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		Energie savedEnergie=new Energie() ;
		savedEnergie.setDes_energie("gazoil");
		savedEnergie=energieRep.save(savedEnergie);
		Energie foundEnergie = energieRep.findByEnergie(savedEnergie.getDes_energie());
		assertNotNull(foundEnergie);
		assertEquals( foundEnergie.getId_energie(), savedEnergie.getId_energie());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		Energie savedEnergie=new Energie() ;
		savedEnergie.setDes_energie("gazoil");
		savedEnergie=energieRep.save(savedEnergie);
		savedEnergie.setDes_energie("gazoil 50");
		savedEnergie = energieRep.save(savedEnergie);
		Energie foundEnergie = energieRep.getOne(savedEnergie.getId_energie());
		assertEquals(foundEnergie.getDes_energie(), savedEnergie.getDes_energie());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		Energie savedEnergie=new Energie() ;
		savedEnergie.setDes_energie("gazoil");
		savedEnergie=energieRep.save(savedEnergie);
		energieRep.delete(savedEnergie);
		Energie foundEnergie = energieRep.findByEnergie(savedEnergie.getDes_energie());
		assertEquals(null, foundEnergie);
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		Energie savedEnergie=new Energie() ;
		savedEnergie.setDes_energie("gazoil");
		savedEnergie=energieRep.save(savedEnergie);
		List<Energie> list = energieRep.findAll();
		assertEquals(1, list.size());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		Energie savedEnergie=new Energie() ;
		savedEnergie.setDes_energie("gazoil");
		savedEnergie=energieRep.save(savedEnergie);
		savedEnergie.setDes_energie("gazoil sans soufre");
		Energie foundEnergie = energieRep.getOne(savedEnergie.getId_energie());
		assertEquals(foundEnergie.getId_energie(), savedEnergie.getId_energie());
		
		
	}

}
