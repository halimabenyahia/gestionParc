package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.Chauffeurs;
import com.auth.entitie.Depense;
import com.test.TestParcRepository;

@SpringBootTest
@Transactional
public class DepenseTestRepository extends TestParcRepository {
	
	@Autowired
	DepenseRepository depenseRep ;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		Depense savedDepense=new Depense() ;
		savedDepense.setDescription_depense("depense1");
		savedDepense=depenseRep.save(savedDepense);
		Depense foundDepense = depenseRep.getbyDescription(savedDepense.getDescription_depense());
		assertNotNull(foundDepense);
		assertEquals( foundDepense.getId_depense(), savedDepense.getId_depense());	
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		Depense savedDepense=new Depense() ;
		savedDepense.setDescription_depense("depense1");
		savedDepense=depenseRep.save(savedDepense);
		savedDepense.setDescription_depense("depense2");
		savedDepense = depenseRep.save(savedDepense);
		Depense foundDepense = depenseRep.getOne(savedDepense.getId_depense());
		assertEquals(foundDepense.getDescription_depense(), savedDepense.getDescription_depense());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		Depense savedDepense=new Depense() ;
		savedDepense.setDescription_depense("depense1");
		savedDepense=depenseRep.save(savedDepense);
		depenseRep.delete(savedDepense);
		Depense foundDepense = depenseRep.getbyDescription(savedDepense.getDescription_depense());
		assertEquals(null, foundDepense);
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		Depense savedDepense=new Depense() ;
		savedDepense.setDescription_depense("depense1");
		savedDepense=depenseRep.save(savedDepense);
		List<Depense> list = depenseRep.findAll();
		assertEquals(1, list.size());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		Depense savedDepense=new Depense() ;
		savedDepense.setDescription_depense("depense1");
		savedDepense=depenseRep.save(savedDepense);
		savedDepense.setDescription_depense("depense1");
		Depense foundDepense = depenseRep.getOne(savedDepense.getId_depense());
		assertEquals(foundDepense.getId_depense(), savedDepense.getId_depense());
		
	}

}
