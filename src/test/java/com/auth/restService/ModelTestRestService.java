package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.ModeleRestService;
import com.auth.entitie.AffectationVehicule;
import com.auth.entitie.Modele;
import com.test.TestParc;
import com.test.TestParcRestController;

public class ModelTestRestService extends TestParcRestController {
	
	ModeleRestService modeleService ;
	
	// Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;

	TestParc testParc;

	@Test
	@Override
	public void getAllEntityList() {
		try {
			Modele modele = new Modele();
			modele.setDes_modele("golf");
			modeleService.addModele(modele);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/modeles").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			Modele[] modeleList = testParc.mapFromJson(content, Modele[].class);
			assertTrue(modeleList.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			Modele modele = new Modele();
			modele.setDes_modele("206");
			modeleService.addModele(modele);
			String inputJson = testParc.mapToJson(modele);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addModele")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Modele foundModele = modeleService.getModeleDes(modele.getDes_modele());
			assertNotNull(foundModele);
			assertEquals(foundModele.getDes_modele(), modele.getDes_modele());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			Modele modele = new Modele();
			modele.setDes_modele("206");
			modele = modeleService.addModele(modele);
			modele.setDes_modele("207");
			String inputJson = testParc.mapToJson(modele);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/editModele")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Modele modeleFound = modeleService.getModeleDes(modele.getDes_modele());
			assertNotNull(modeleFound);
			assertEquals(modeleFound.getDes_modele(), modele.getDes_modele());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			Modele modele = new Modele();
			modele.setDes_modele("golf");
			modele = modeleService.addModele(modele);
			String inputJson = testParc.mapToJson(modele);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteModele")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Modele modeleFound = modeleService.getModeleDes(modele.getDes_modele());
			assertEquals(null, modeleFound);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
