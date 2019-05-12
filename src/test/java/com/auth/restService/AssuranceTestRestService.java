package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.AssuranceRestService;
import com.auth.entitie.Assurance;
import com.auth.entitie.Chauffeurs;
import com.test.TestParc;
import com.test.TestParcRestController;

public class AssuranceTestRestService extends TestParcRestController {
	
	AssuranceRestService assuranceService ;
	
	// Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;

	TestParc testParc;

	@Test
	@Override
	public void getAllEntityList() {
		try {
			Assurance assurance = new Assurance();
			assurance.setCompagnie_ass("gat");;
			assuranceService.addAssurance(assurance);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/Assurance").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			Assurance[] assuranceList = testParc.mapFromJson(content, Assurance[].class);
			assertTrue(assuranceList.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			Assurance assurance = new Assurance();
			assurance.setCompagnie_ass("biat");;
			assuranceService.addAssurance(assurance);
			String inputJson = testParc.mapToJson(assurance);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addAssurance")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Assurance foundAssurance = assuranceService.getAssuranceCompagnie(assurance.getCompagnie_ass());
			assertNotNull(foundAssurance);
			assertEquals(foundAssurance.getCompagnie_ass(), assurance.getCompagnie_ass());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			Assurance assurance = new Assurance();
			assurance.setCompagnie_ass("biat");
			assurance = assuranceService.addAssurance(assurance);
			assurance.setCompagnie_ass("biaatt");
			String inputJson = testParc.mapToJson(assurance);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/addAssurance")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Assurance assuranceFound = assuranceService.getAssuranceCompagnie(assurance.getCompagnie_ass());
			assertNotNull(assuranceFound);
			assertEquals(assuranceFound.getCompagnie_ass(), assurance.getCompagnie_ass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			Assurance assurance = new Assurance();
			assurance.setCompagnie_ass("biat");
			assurance = assuranceService.addAssurance(assurance);
			String inputJson = testParc.mapToJson(assurance);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteAssurance")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Assurance assuranceFound = assuranceService.getAssuranceCompagnie(assurance.getCompagnie_ass());
			assertEquals(null, assuranceFound);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
