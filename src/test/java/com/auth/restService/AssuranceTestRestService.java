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
			List<Assurance> foundAssurance = assuranceService.getAssuranceParam(assurance.getCompagnie_ass());
			assertNotNull(foundAssurance);
		//	assertEquals(foundAssurance., assurance.getCompagnie_ass();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void updateEntity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntity() {
		// TODO Auto-generated method stub
		
	}

}
