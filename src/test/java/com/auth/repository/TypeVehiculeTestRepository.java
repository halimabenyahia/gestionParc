package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.TypePiece;
import com.auth.entitie.TypeVehicule;
import com.test.TestParcRepository;

@SpringBootTest
@Transactional
public class TypeVehiculeTestRepository extends TestParcRepository {
	
	@Autowired
	TypeVehiculeRepository typeVehiculeRep ;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		TypeVehicule savedTypeVehicule=new TypeVehicule() ;
		savedTypeVehicule.setDes_typeVehicule("partner");
		savedTypeVehicule=typeVehiculeRep.save(savedTypeVehicule);
		TypeVehicule foundTypeVehicule = typeVehiculeRep.findByTypeVehicule(savedTypeVehicule.getDes_typeVehicule());
		assertNotNull(foundTypeVehicule);
		assertEquals( foundTypeVehicule.getId_typeVehicule(), savedTypeVehicule.getId_typeVehicule());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		TypeVehicule savedTypeVehicule=new TypeVehicule() ;
		savedTypeVehicule.setDes_typeVehicule("partner");
		savedTypeVehicule=typeVehiculeRep.save(savedTypeVehicule);
		savedTypeVehicule.setDes_typeVehicule("camion");
		savedTypeVehicule=typeVehiculeRep.save(savedTypeVehicule);
		TypeVehicule foundTypeVehicule = typeVehiculeRep.getOne(savedTypeVehicule.getId_typeVehicule());
		assertEquals(foundTypeVehicule.getDes_typeVehicule(), savedTypeVehicule.getDes_typeVehicule());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		TypeVehicule savedTypeVehicule=new TypeVehicule() ;
		savedTypeVehicule.setDes_typeVehicule("partner");
		savedTypeVehicule=typeVehiculeRep.save(savedTypeVehicule);
		typeVehiculeRep.delete(savedTypeVehicule);
		TypeVehicule foundTypeVehicule = typeVehiculeRep.findByTypeVehicule(savedTypeVehicule.getDes_typeVehicule());
		assertEquals(null, foundTypeVehicule);
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		TypeVehicule savedTypeVehicule=new TypeVehicule() ;
		savedTypeVehicule.setDes_typeVehicule("partner");
		savedTypeVehicule=typeVehiculeRep.save(savedTypeVehicule);
		List<TypeVehicule> list = typeVehiculeRep.findAll();
		assertEquals(1, list.size());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		TypeVehicule savedTypeVehicule=new TypeVehicule() ;
		savedTypeVehicule.setDes_typeVehicule("partner");
		savedTypeVehicule=typeVehiculeRep.save(savedTypeVehicule);
		savedTypeVehicule.setDes_typeVehicule("partner");
		TypeVehicule foundTypeVehicule = typeVehiculeRep.getOne(savedTypeVehicule.getId_typeVehicule());
		assertEquals(foundTypeVehicule.getId_typeVehicule(), savedTypeVehicule.getId_typeVehicule());
		
	}

}
