package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.TypeBoiteRestService;
import com.auth.entitie.Chauffeurs;
import com.auth.entitie.TypeBoite;
import com.test.TestParc;
import com.test.TestParcRestController;

public class TypeBoiteTestRestService extends TestParcRestController {
	
	TypeBoiteRestService typeBoiteService ;
	
	// Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;

	TestParc testParc;

	@Test
	@Override
	public void getAllEntityList() {
		try {
			TypeBoite boite = new TypeBoite();
			boite.setDes_boite("auto");
			typeBoiteService.addBoite(boite);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/typeBoites").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			TypeBoite[] boiteList = testParc.mapFromJson(content, TypeBoite[].class);
			assertTrue(boiteList.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			TypeBoite boite = new TypeBoite();
			boite.setDes_boite("automatique");
			typeBoiteService.addBoite(boite);
			String inputJson = testParc.mapToJson(boite);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addtypeBoite")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypeBoite foundboite = typeBoiteService.getBoiteDes(boite.getDes_boite());
			assertNotNull(foundboite);
			assertEquals(foundboite.getDes_boite(), boite.getDes_boite());

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			TypeBoite boite = new TypeBoite();
			boite.setDes_boite("automatique");
			boite = typeBoiteService.addBoite(boite);
			boite.setDes_boite("automatiquuuee");
			String inputJson = testParc.mapToJson(boite);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/editTypeBoite")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypeBoite boiteFound = typeBoiteService.getBoiteDes(boite.getDes_boite());
			assertNotNull(boiteFound);
			assertEquals(boiteFound.getDes_boite(), boite.getDes_boite());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			TypeBoite boite = new TypeBoite();
			boite.setDes_boite("auto");
			boite = typeBoiteService.addBoite(boite);
			String inputJson = testParc.mapToJson(boite);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteTypeBoite")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypeBoite boiteFound = typeBoiteService.getBoiteDes(boite.getDes_boite());
			assertEquals(null, boiteFound);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
