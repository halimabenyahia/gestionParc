package com.auth.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.auth.controller.ChauffeursRestService;
import com.auth.entitie.Chauffeurs;
import com.test.TestParcService;

@SpringBootTest()
public class ChauffeurTestService extends TestParcService{
	
//	@Mock
//	@Autowired
//	ChauffeursRestService chauffeurServiceMock;
//	
	@Autowired
	ChauffeursRestService chauffeurServiceNonMocked;

	@Test
	@Override
	public void givenEntityService_whenSaving() {
		Chauffeurs savedChauffeur = new Chauffeurs();
		savedChauffeur.setNom_ch("ben");
		savedChauffeur = chauffeurServiceNonMocked.addChauffeur(savedChauffeur);
		Chauffeurs foundChauffeur = chauffeurServiceNonMocked.getChauffeurbynom(savedChauffeur.getNom_ch());
		System.out.println("--------------- Searching for Garantie ---------------");
		assertNotNull(foundChauffeur);
		assertEquals(foundChauffeur.getId_chauffeur(), savedChauffeur.getId_chauffeur());
		
		
	}

	@Override
	public void givenEntityService_whenUpdating() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void givenEntityService_whenDeleting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void givenEntityService_whenRetrievingAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void givenEntityService_whenRetrievingOneById() {
		// TODO Auto-generated method stub
		
	}

}
