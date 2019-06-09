package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.controller.ProgrammeEntretienRestService;
import com.auth.entitie.Energie;
import com.auth.entitie.ProgrammeEntretien;
import com.test.TestParcRepository;

@SpringBootTest
@Transactional
public class EntretienTestRepository extends TestParcRepository {
	
	@Autowired
	ProgrammeEntretienRepository entretienRep ;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		ProgrammeEntretien savedProgrammeEntretien=new ProgrammeEntretien() ;
		savedProgrammeEntretien.setDescription("entretien1");
		savedProgrammeEntretien=entretienRep.save(savedProgrammeEntretien);
		ProgrammeEntretien foundProgrammeEntretien = entretienRep.findByDescription(savedProgrammeEntretien.getDescription());
		assertNotNull(foundProgrammeEntretien);
		assertEquals( foundProgrammeEntretien.getId_programme(), savedProgrammeEntretien.getId_programme());
		
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		ProgrammeEntretien savedProgrammeEntretien=new ProgrammeEntretien() ;
		savedProgrammeEntretien.setDescription("entretien1");
		savedProgrammeEntretien=entretienRep.save(savedProgrammeEntretien);
		savedProgrammeEntretien.setDescription("entretien2");
		savedProgrammeEntretien = entretienRep.save(savedProgrammeEntretien);
		ProgrammeEntretien foundProgrammeEntretien = entretienRep.getOne(savedProgrammeEntretien.getId_programme());
		assertEquals(foundProgrammeEntretien.getDescription(), savedProgrammeEntretien.getDescription());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		ProgrammeEntretien savedProgrammeEntretien=new ProgrammeEntretien() ;
		savedProgrammeEntretien.setDescription("entretien1");
		savedProgrammeEntretien=entretienRep.save(savedProgrammeEntretien);
		entretienRep.delete(savedProgrammeEntretien);
		ProgrammeEntretien foundProgrammeEntretien = entretienRep.findByDescription(savedProgrammeEntretien.getDescription());
		assertEquals(null, foundProgrammeEntretien);
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		ProgrammeEntretien savedProgrammeEntretien=new ProgrammeEntretien() ;
		savedProgrammeEntretien.setDescription("entretien1");
		savedProgrammeEntretien=entretienRep.save(savedProgrammeEntretien);
		List<ProgrammeEntretien> list = entretienRep.findAll();
		assertEquals(1, list.size());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		ProgrammeEntretien savedProgrammeEntretien=new ProgrammeEntretien() ;
		savedProgrammeEntretien.setDescription("entretien1");
		savedProgrammeEntretien=entretienRep.save(savedProgrammeEntretien);
		savedProgrammeEntretien.setDescription("entretien1");
		ProgrammeEntretien foundProgrammeEntretien = entretienRep.getOne(savedProgrammeEntretien.getId_programme());
		assertEquals(foundProgrammeEntretien.getId_programme(), savedProgrammeEntretien.getId_programme());
		
	}

}
