package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.EnergieRestService;
import com.auth.entitie.Chauffeurs;
import com.auth.entitie.Energie;
import com.test.TestParc;
import com.test.TestParcRestController;

public class EnergieTestRestService extends TestParcRestController {
	
	EnergieRestService energieService ;
	
	// Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;

	TestParc testParc;

	@Test
	@Override
	public void getAllEntityList() {
		try {
			Energie energie = new Energie();
			energie.setDes_energie("gazoil");
			energieService.addEnergie(energie);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/energies").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			Energie[] energieList = testParc.mapFromJson(content, Energie[].class);
			assertTrue(energieList.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			Energie energie = new Energie();
			energie.setDes_energie("essence");
			energieService.addEnergie(energie);
			String inputJson = testParc.mapToJson(energie);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addEnergie")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Energie foundEnergie = energieService.getEnergieDes(energie.getDes_energie());
			assertNotNull(foundEnergie);
			assertEquals(foundEnergie.getDes_energie(), energie.getDes_energie());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			Energie energie = new Energie();
			energie.setDes_energie("essence");
			energie = energieService.addEnergie(energie);
			energie.setDes_energie("essence sans plomb");
			String inputJson = testParc.mapToJson(energie);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/editEnergie")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Energie energieFound = energieService.getEnergieDes(energie.getDes_energie());
			assertNotNull(energieFound);
			assertEquals(energieFound.getDes_energie(), energie.getDes_energie());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			Energie energie = new Energie();
			energie.setDes_energie("essence");
			energie = energieService.addEnergie(energie);
			String inputJson = testParc.mapToJson(energie);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteEnergie")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Energie energieFound = energieService.getEnergieDes(energie.getDes_energie());
			assertEquals(null, energieFound);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
