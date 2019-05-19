package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.DepenseRestService;
import com.auth.entitie.AffectationVehicule;
import com.auth.entitie.Depense;
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
			depense.setType_depense("carburant");
			depenseService.addDepense(depense);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/listdepenses").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			Depense[] depenseList = testParc.mapFromJson(content, Depense[].class);
			assertTrue(depenseList.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			Depense depense = new Depense();
			depense.setType_depense("carburant");
			depenseService.addDepense(depense);
			String inputJson = testParc.mapToJson(depense);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addDepense")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Depense foundDepense = depenseService.getDepenseByTypeD(depense.getType_depense());
			assertNotNull(foundDepense);
			assertEquals(foundDepense.getType_depense(), depense.getType_depense());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			Depense depense = new Depense();
			depense.setType_depense("carburant");
			depense = depenseService.addDepense(depense);
			depense.setType_depense("energie");
			String inputJson = testParc.mapToJson(depense);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/editDepense")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Depense depenseFound = depenseService.getDepenseByTypeD(depense.getType_depense());
			assertNotNull(depenseFound);
			assertEquals(depenseFound.getType_depense(), depense.getType_depense());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			Depense depense = new Depense();
			depense.setType_depense("carburant");
			depense = depenseService.addDepense(depense);
			String inputJson = testParc.mapToJson(depense);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteDepense")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Depense depenseFound = depenseService.getDepenseByTypeD(depense.getType_depense());
			assertEquals(null, depenseFound);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
