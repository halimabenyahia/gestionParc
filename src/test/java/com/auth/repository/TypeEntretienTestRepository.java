package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.TypeDepense;
import com.auth.entitie.TypeEntretien;
import com.test.TestParcRepository;

@SpringBootTest
@Transactional
public class TypeEntretienTestRepository extends TestParcRepository {
	
	@Autowired
	TypeEntretienRepository typeEntretienRep ;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		TypeEntretien savedTypeEntretien=new TypeEntretien() ;
		savedTypeEntretien.setDes_typeEntretien("vidange");
		savedTypeEntretien=typeEntretienRep.save(savedTypeEntretien);
		TypeEntretien foundTypeEntretien = typeEntretienRep.findByTypeEntretienDes(savedTypeEntretien.getDes_typeEntretien());
		assertNotNull(foundTypeEntretien);
		assertEquals( foundTypeEntretien.getId_typeEntretien(), savedTypeEntretien.getId_typeEntretien());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		TypeEntretien savedTypeEntretien=new TypeEntretien() ;
		savedTypeEntretien.setDes_typeEntretien("vidange");
		savedTypeEntretien=typeEntretienRep.save(savedTypeEntretien);
		savedTypeEntretien.setDes_typeEntretien("carbb");
		savedTypeEntretien=typeEntretienRep.save(savedTypeEntretien);
		TypeEntretien foundTypeEntretien = typeEntretienRep.getOne(savedTypeEntretien.getId_typeEntretien());
		assertEquals(foundTypeEntretien.getDes_typeEntretien(), savedTypeEntretien.getDes_typeEntretien());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		TypeEntretien savedTypeEntretien=new TypeEntretien() ;
		savedTypeEntretien.setDes_typeEntretien("vidange");
		savedTypeEntretien=typeEntretienRep.save(savedTypeEntretien);
		typeEntretienRep.delete(savedTypeEntretien);
		TypeEntretien foundTypeEntretien = typeEntretienRep.findByTypeEntretienDes(savedTypeEntretien.getDes_typeEntretien());
		assertEquals(null, foundTypeEntretien);
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		TypeEntretien savedTypeEntretien=new TypeEntretien() ;
		savedTypeEntretien.setDes_typeEntretien("vidange");
		savedTypeEntretien=typeEntretienRep.save(savedTypeEntretien);
		List<TypeEntretien> list = typeEntretienRep.findAll();
		assertEquals(1, list.size());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		TypeEntretien savedTypeEntretien=new TypeEntretien() ;
		savedTypeEntretien.setDes_typeEntretien("vidange");
		savedTypeEntretien=typeEntretienRep.save(savedTypeEntretien);
		savedTypeEntretien.setDes_typeEntretien("vidange");
		TypeEntretien foundTypeEntretien = typeEntretienRep.getOne(savedTypeEntretien.getId_typeEntretien());
		assertEquals(foundTypeEntretien.getId_typeEntretien(), savedTypeEntretien.getId_typeEntretien());
		
	}

}
