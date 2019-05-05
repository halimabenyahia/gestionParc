package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.ChauffeursRestService;
import com.auth.entitie.Chauffeurs;
import com.test.TestParc;
import com.test.TestParcRestController;

public class ChauffeurTestRestService extends TestParcRestController {
	
ChauffeursRestService chauffeurService ;
	
	//Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;
	
	
	TestParc testParc ;
	
//	public public ChauffeurTestRestController() {
//		super();
//	}

	@Test
	@Override
	public void getAllEntityList() {
		try {
			Chauffeurs chauffeur = new Chauffeurs();
			chauffeur.setNom_ch("yahia");
			chauffeurService.addChauffeur(chauffeur);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/chauffeurs").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			Chauffeurs[] chauffeurList = testParc.mapFromJson(content, Chauffeurs[].class);
			assertTrue(chauffeurList.length > 0);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			Chauffeurs chauffeur = new Chauffeurs();
			chauffeur.setNom_ch("yahia");
			chauffeurService.addChauffeur(chauffeur);
			String inputJson = testParc.mapToJson(chauffeur);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addChauffeur").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Chauffeurs foundChauffeurs = chauffeurService.getChauffeurParam(chauffeur.getNom_ch());
			assertNotNull(foundChauffeurs);
			assertEquals(foundChauffeurs.getNom_ch(), chauffeur.getNom_ch());

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
		Chauffeurs chauffeur = new Chauffeurs() ;
		chauffeur.setNom_ch("yahia");
		chauffeur = chauffeurService.addChauffeur(chauffeur);
		chauffeur.setNom_ch("yahya");
		String inputJson = testParc.mapToJson(chauffeur);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put( "/editChauffeur")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		Chauffeurs chauffeurFound = chauffeurService.getChauffeurParam(chauffeur.getNom_ch());
		assertNotNull(chauffeurFound);
		assertEquals(chauffeurFound.getNom_ch(), chauffeur.getNom_ch());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			Chauffeurs chauffeur = new Chauffeurs();
			chauffeur.setNom_ch("yahia");
			chauffeur = chauffeurService.addChauffeur(chauffeur);
			String inputJson = testParc.mapToJson(chauffeur);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteChauffeur").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Chauffeurs chauffeurFound = chauffeurService.getChauffeurParam(chauffeur.getNom_ch());
			assertEquals(null, chauffeurFound);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
