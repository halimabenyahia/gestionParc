package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.Modele;
import com.test.TestParcRepository;

@SpringBootTest
@Transactional
public class ModeleTestRepository extends TestParcRepository {
	
	@Autowired
	ModeleRepository modeleRep ;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		Modele savedModele=new Modele() ;
		savedModele.setDes_modele("206");
		savedModele=modeleRep.save(savedModele);
		Modele foundModele = modeleRep.findByModelDes(savedModele.getDes_modele());
		assertNotNull(foundModele);
		assertEquals( foundModele.getId_modele(), savedModele.getId_modele());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		Modele savedModele=new Modele() ;
		savedModele.setDes_modele("206");
		savedModele=modeleRep.save(savedModele);
		savedModele.setDes_modele("207");
		savedModele=modeleRep.save(savedModele);
		Modele foundModele = modeleRep.getOne(savedModele.getId_modele());
		assertEquals(foundModele.getDes_modele(), savedModele.getDes_modele());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		Modele savedModele=new Modele() ;
		savedModele.setDes_modele("206");
		savedModele=modeleRep.save(savedModele);
		modeleRep.delete(savedModele);
		Modele foundModele = modeleRep.findByModelDes(savedModele.getDes_modele());
		assertEquals(null, foundModele);
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		Modele savedModele=new Modele() ;
		savedModele.setDes_modele("206");
		savedModele=modeleRep.save(savedModele);
		List<Modele> list = modeleRep.findAll();
		assertEquals(1, list.size());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		Modele savedModele=new Modele() ;
		savedModele.setDes_modele("206");
		savedModele=modeleRep.save(savedModele);
		savedModele.setDes_modele("208");
		Modele foundModele = modeleRep.getOne(savedModele.getId_modele());
		assertEquals(foundModele.getId_modele(), savedModele.getId_modele());
		
	}

}
