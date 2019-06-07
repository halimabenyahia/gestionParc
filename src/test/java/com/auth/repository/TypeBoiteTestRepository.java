package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.Piece;
import com.auth.entitie.TypeBoite;
import com.test.TestParcRepository;

@SpringBootTest
@Transactional
public class TypeBoiteTestRepository extends TestParcRepository {
	
	@Autowired
	TypeBoiteRepository typeBoiteRep;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		TypeBoite savedTypeBoite=new TypeBoite() ;
		savedTypeBoite.setDes_boite("auto");
		savedTypeBoite=typeBoiteRep.save(savedTypeBoite);
		TypeBoite foundTypeBoite = typeBoiteRep.findByBoite(savedTypeBoite.getDes_boite());
		assertNotNull(foundTypeBoite);
		assertEquals( foundTypeBoite.getId_typeBoite(), savedTypeBoite.getId_typeBoite());
		
		
	}
	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		TypeBoite savedTypeBoite=new TypeBoite() ;
		savedTypeBoite.setDes_boite("auto");
		savedTypeBoite=typeBoiteRep.save(savedTypeBoite);
		savedTypeBoite.setDes_boite("automatique");
		savedTypeBoite=typeBoiteRep.save(savedTypeBoite);
		TypeBoite foundTypeBoite = typeBoiteRep.getOne(savedTypeBoite.getId_typeBoite());
		assertEquals(foundTypeBoite.getDes_boite(), savedTypeBoite.getDes_boite());
		
	}
	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		TypeBoite savedTypeBoite=new TypeBoite() ;
		savedTypeBoite.setDes_boite("auto");
		savedTypeBoite=typeBoiteRep.save(savedTypeBoite);
		typeBoiteRep.delete(savedTypeBoite);
		TypeBoite foundTypeBoite = typeBoiteRep.findByBoite(savedTypeBoite.getDes_boite());
		assertEquals(null, foundTypeBoite);

		
	}
	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		TypeBoite savedTypeBoite=new TypeBoite() ;
		savedTypeBoite.setDes_boite("auto");
		savedTypeBoite=typeBoiteRep.save(savedTypeBoite);
		List<TypeBoite> list = typeBoiteRep.findAll();
		assertEquals(1, list.size());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		TypeBoite savedTypeBoite=new TypeBoite() ;
		savedTypeBoite.setDes_boite("auto");
		savedTypeBoite=typeBoiteRep.save(savedTypeBoite);
		savedTypeBoite.setDes_boite("manuelle");
		TypeBoite foundTypeBoite = typeBoiteRep.getOne(savedTypeBoite.getId_typeBoite());
		assertEquals(foundTypeBoite.getId_typeBoite(), savedTypeBoite.getId_typeBoite());
		
	}

}
