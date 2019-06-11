package com.auth.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.auth.controller.ChauffeursRestService;
import com.auth.entitie.Chauffeurs;
import com.test.TestParcService;

@SpringBootTest
public class ChauffeurTestService extends TestParcService{
	
	@Mock
	@Autowired
	ChauffeursRestService chauffeurServiceMock;
	
	@Autowired
	ChauffeursRestService chauffeurServiceNonMocked;

	@Test
	@Override
	public void givenEntityService_whenSaving() {
		Chauffeurs savedChauffeur = new Chauffeurs();
		savedChauffeur.setNom_ch("ben");
		savedChauffeur = chauffeurServiceNonMocked.addChauffeur(savedChauffeur);
		Chauffeurs foundChauffeur = chauffeurServiceNonMocked.getChauffeurbynom(savedChauffeur.getNom_ch());
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

	@Test
	@Override
	public void givenEntityService_whenRetrievingAll() {
		List<Chauffeurs> listChauffeurTOsave = new ArrayList<Chauffeurs>();
		List<Chauffeurs> listChauffeurTOget = new ArrayList<Chauffeurs>();
		/****************************************************************************/
		
		Chauffeurs savedChauffeur1 = new Chauffeurs();
		savedChauffeur1.setNom_ch("yahiaa");
		savedChauffeur1 =  chauffeurServiceNonMocked.addChauffeur(savedChauffeur1);
		listChauffeurTOsave.add(savedChauffeur1);
		
		/******************************************************************************/
		
		Chauffeurs savedChauffeur2 = new Chauffeurs();
		savedChauffeur2.setNom_ch("yahyaa");
		savedChauffeur2 =  chauffeurServiceNonMocked.addChauffeur(savedChauffeur2);
		listChauffeurTOsave.add(savedChauffeur2);
		
		/****************************************************************************/
		
		Chauffeurs savedChauffeur3 = new Chauffeurs();
		savedChauffeur3.setNom_ch("yahyayy");
		savedChauffeur3 =  chauffeurServiceNonMocked.addChauffeur(savedChauffeur3);
		listChauffeurTOsave.add(savedChauffeur3);
		
		/******************************************************************************/
		
		listChauffeurTOget =  chauffeurServiceNonMocked.getChauffeurs();
		assertEquals(listChauffeurTOsave.size(), listChauffeurTOget.size());
		}

	@Override
	public void givenEntityService_whenRetrievingOneById() {
		// TODO Auto-generated method stub
		
	}

}
