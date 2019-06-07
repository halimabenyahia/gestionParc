package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.TypeBoite;
import com.auth.entitie.TypeDepense;
import com.test.TestParcRepository;

@SpringBootTest
@Transactional
public class TypeDepenseTestRepository extends TestParcRepository {
	
	@Autowired
	TypeDepenseRepository typeDepRep ;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		TypeDepense savedTypeDepense=new TypeDepense() ;
		savedTypeDepense.setDesignation_typeDep("piece");
		savedTypeDepense=typeDepRep.save(savedTypeDepense);
		TypeDepense foundTypeDepense = typeDepRep.findByTypeDepense(savedTypeDepense.getDesignation_typeDep());
		assertNotNull(foundTypeDepense);
		assertEquals( foundTypeDepense.getId_typeDepense(), savedTypeDepense.getId_typeDepense());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		TypeDepense savedTypeDepense=new TypeDepense() ;
		savedTypeDepense.setDesignation_typeDep("piece");
		savedTypeDepense=typeDepRep.save(savedTypeDepense);
		savedTypeDepense.setDesignation_typeDep("carburant");
		savedTypeDepense=typeDepRep.save(savedTypeDepense);
		TypeDepense foundTypeDepense = typeDepRep.getOne(savedTypeDepense.getId_typeDepense());
		assertEquals(foundTypeDepense.getDesignation_typeDep(), savedTypeDepense.getDesignation_typeDep());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		TypeDepense savedTypeDepense=new TypeDepense() ;
		savedTypeDepense.setDesignation_typeDep("piece");
		savedTypeDepense=typeDepRep.save(savedTypeDepense);
		typeDepRep.delete(savedTypeDepense);
		TypeDepense foundTypeDepense = typeDepRep.findByTypeDepense(savedTypeDepense.getDesignation_typeDep());
		assertEquals(null, foundTypeDepense);
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		TypeDepense savedTypeDepense=new TypeDepense() ;
		savedTypeDepense.setDesignation_typeDep("piece");
		savedTypeDepense=typeDepRep.save(savedTypeDepense);
		List<TypeDepense> list = typeDepRep.findAll();
		assertEquals(1, list.size());
		
	}
	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		TypeDepense savedTypeDepense=new TypeDepense() ;
		savedTypeDepense.setDesignation_typeDep("piece");
		savedTypeDepense=typeDepRep.save(savedTypeDepense);
		savedTypeDepense.setDesignation_typeDep("carbuu");
		TypeDepense foundTypeDepense = typeDepRep.getOne(savedTypeDepense.getId_typeDepense());
		assertEquals(foundTypeDepense.getId_typeDepense(), savedTypeDepense.getId_typeDepense());
		
		
	}
	

}
