package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.DepenseRestService;
import com.auth.entitie.Depense;
import com.auth.entitie.Energie;
import com.test.TestParc;
import com.test.TestParcRestController;

public class DepenseTestRestService extends TestParcRestController {
	
	DepenseRestService depenseService ;
	
	// Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;

	TestParc testParc;

	@Test
	@Override
	public void getAllEntityList() {
		try {
			Depense depense = new Depense();
			depense.setDescription_depense("depense 1");
			depenseService.addDepense(depense);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/listdepenses").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			Depense[] ListDepense = testParc.mapFromJson(content, Depense[].class);
			assertTrue(ListDepense.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			Depense depense = new Depense();
			depense.setDescription_depense("depense 1");
			depenseService.addDepense(depense);
			String inputJson = testParc.mapToJson(depense);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addDepense")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Depense foundEnergie = depenseService.getDepenseByDesTest(depense.getDescription_depense());
			assertNotNull(foundEnergie);
			assertEquals(foundEnergie.getDescription_depense(), depense.getDescription_depense());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			Depense depense = new Depense();
			depense.setDescription_depense("depense 1");
			depenseService.addDepense(depense);
			depense.setDescription_depense("depense 2");
			String inputJson = testParc.mapToJson(depense);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/editDepense")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Depense FoundDepense = depenseService.getDepenseByDesTest(depense.getDescription_depense());
			assertNotNull(FoundDepense);
			assertEquals(FoundDepense.getDescription_depense(), depense.getDescription_depense());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			Depense depense = new Depense();
			depense.setDescription_depense("depense 1");
			depenseService.addDepense(depense);
			String inputJson = testParc.mapToJson(depense);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteDepense")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Depense FoundDepense = depenseService.getDepenseByDesTest(depense.getDescription_depense());
			assertEquals(null, FoundDepense);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
