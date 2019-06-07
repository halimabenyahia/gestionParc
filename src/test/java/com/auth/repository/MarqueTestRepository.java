package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.Marque;
import com.test.TestParcRepository;

@SpringBootTest
@Transactional
public class MarqueTestRepository extends TestParcRepository {
	
	@Autowired
	MarqueRepository marqueRep ;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		Marque savedMarque=new Marque() ;
		savedMarque.setDes_marque("fiat");
		savedMarque=marqueRep.save(savedMarque);
		Marque foundMarque = marqueRep.findByDesignation(savedMarque.getDes_marque());
		assertNotNull(foundMarque);
		assertEquals( foundMarque.getId_marque(), savedMarque.getId_marque());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		Marque savedMarque=new Marque() ;
		savedMarque.setDes_marque("fiat");
		savedMarque=marqueRep.save(savedMarque);
		savedMarque.setDes_marque("toyota");
		savedMarque = marqueRep.save(savedMarque);
		Marque foundMarque = marqueRep.getOne(savedMarque.getId_marque());
		assertEquals(foundMarque.getDes_marque(), savedMarque.getDes_marque());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		Marque savedMarque=new Marque() ;
		savedMarque.setDes_marque("fiat");
		savedMarque=marqueRep.save(savedMarque);
		marqueRep.delete(savedMarque);
		Marque foundMarque = marqueRep.findByDesignation(savedMarque.getDes_marque());
		assertEquals(null, foundMarque);
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		Marque savedMarque=new Marque() ;
		savedMarque.setDes_marque("fiat");
		savedMarque=marqueRep.save(savedMarque);
		List<Marque> list = marqueRep.findAll();
		assertEquals(1, list.size());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		Marque savedMarque=new Marque() ;
		savedMarque.setDes_marque("fiat");
		savedMarque=marqueRep.save(savedMarque);
		savedMarque.setDes_marque("fiat500");
		Marque foundMarque = marqueRep.getOne(savedMarque.getId_marque());
		assertEquals(foundMarque.getId_marque(), savedMarque.getId_marque());
		
	}

}
