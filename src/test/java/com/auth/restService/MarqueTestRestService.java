package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.MarqueRestService;
import com.auth.entitie.Marque;
import com.test.TestParc;
import com.test.TestParcRestController;

public class MarqueTestRestService extends TestParcRestController {
	
	MarqueRestService marqueService ;
	
	// Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;

	TestParc testParc;

	@Test
	@Override
	public void getAllEntityList() {
		try {
			Marque marque = new Marque();
			marque.setDes_marque("bmw");
			marqueService.addMarque(marque);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/marques").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			Marque[] marqueList = testParc.mapFromJson(content, Marque[].class);
			assertTrue(marqueList.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			Marque marque = new Marque();
			marque.setDes_marque("opel");
			marqueService.addMarque(marque);
			String inputJson = testParc.mapToJson(marque);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addMarque")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Marque foundMarque = marqueService.getMarqueDes(marque.getDes_marque());
			assertNotNull(foundMarque);
			assertEquals(foundMarque.getDes_marque(), marque.getDes_marque());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			Marque marque = new Marque();
			marque.setDes_marque("bmw");
			marque = marqueService.addMarque(marque);
			marque.setDes_marque("bm");
			String inputJson = testParc.mapToJson(marque);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/editMarque")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Marque marqueFound = marqueService.getMarqueDes(marque.getDes_marque());
			assertNotNull(marqueFound);
			assertEquals(marqueFound.getDes_marque(), marque.getDes_marque());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			Marque marque = new Marque();
			marque.setDes_marque("bm");
			marque = marqueService.addMarque(marque);
			String inputJson = testParc.mapToJson(marque);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteMarque")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Marque marqueFound = marqueService.getMarqueDes(marque.getDes_marque());
			assertEquals(null, marqueFound);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
