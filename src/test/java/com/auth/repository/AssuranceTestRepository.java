package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.Assurance;
import com.auth.entitie.Chauffeurs;
import com.test.TestParcRepository;

@SpringBootTest
@Transactional
public class AssuranceTestRepository extends TestParcRepository  {
	
	@Autowired
	AssuranceRepository assuranceRep ;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		
		Assurance savedAssurance=new Assurance() ;
		savedAssurance.setCompagnie_ass("star");
		savedAssurance=assuranceRep.save(savedAssurance);
		Assurance foundAssurance = assuranceRep.findByAssurance(savedAssurance.getCompagnie_ass());
		assertNotNull(foundAssurance);
		assertEquals( foundAssurance.getId_assurance(), savedAssurance.getId_assurance());	
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		System.out.println("--------------- Testing givenEntityRepository_whenUpdating Method ---------------");
		Assurance savedAssurance=new Assurance() ;
		savedAssurance.setCompagnie_ass("star");
		savedAssurance = assuranceRep.save(savedAssurance);
		savedAssurance.setCompagnie_ass("starrr");
		savedAssurance = assuranceRep.save(savedAssurance);
		Assurance foundAssurance = assuranceRep.getOne(savedAssurance.getId_assurance());
		assertEquals(foundAssurance.getCompagnie_ass(), savedAssurance.getCompagnie_ass());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		Assurance savedAssurance = new Assurance() ;
		savedAssurance.setCompagnie_ass("star");
		savedAssurance = assuranceRep.save(savedAssurance);
		assuranceRep.delete(savedAssurance);
		Assurance foundAssurance = assuranceRep.findByAssurance(savedAssurance.getCompagnie_ass());
		assertEquals(null, foundAssurance);
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		Assurance savedAssurance = new Assurance() ;
		savedAssurance.setCompagnie_ass("star");
		savedAssurance = assuranceRep.save(savedAssurance);
		List<Assurance> list = assuranceRep.findAll();
		assertEquals(1, list.size());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		Assurance savedAssurance = new 		Assurance();
		savedAssurance.setCompagnie_ass("star");
		savedAssurance = assuranceRep.save(savedAssurance);
		savedAssurance.setCompagnie_ass("comar");
		Assurance foundAssurance = assuranceRep.getOne(savedAssurance.getId_assurance());
		assertEquals(foundAssurance.getId_assurance(), savedAssurance.getId_assurance());
		
	}

}
