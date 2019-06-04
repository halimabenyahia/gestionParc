package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.TypeDepenseRestService;
import com.auth.entitie.TypeDepense;
import com.test.TestParc;
import com.test.TestParcRestController;

public class TypeDepenseTestRestService extends TestParcRestController{
	
	TypeDepenseRestService typeDepService ;

	// Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;

	TestParc testParc;

	@Test
	@Override
	public void getAllEntityList() {
		try {
			TypeDepense typeDepense = new TypeDepense();
			typeDepense.setDesignation_typeDep("carburant");
			typeDepService.addTypeDepense(typeDepense);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/typeDepenses").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			TypeDepense[] depenseList = testParc.mapFromJson(content, TypeDepense[].class);
			assertTrue(depenseList.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			TypeDepense typeDepense = new TypeDepense();
			typeDepense.setDesignation_typeDep("carburants");
			typeDepService.addTypeDepense(typeDepense);
			String inputJson = testParc.mapToJson(typeDepense);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addTypeDepense")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypeDepense foundtypeDep = typeDepService.getTypedepenseDes(typeDepense.getDesignation_typeDep());
			assertNotNull(foundtypeDep);
			assertEquals(foundtypeDep.getDesignation_typeDep(), foundtypeDep.getDesignation_typeDep());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			TypeDepense typeDepense = new TypeDepense();
			typeDepense.setDesignation_typeDep("carburant");
			typeDepense = typeDepService.addTypeDepense(typeDepense);
			typeDepense.setDesignation_typeDep("piece");
			String inputJson = testParc.mapToJson(typeDepense);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/editTypeDepense")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypeDepense typeDepFound = typeDepService.getTypedepenseDes(typeDepense.getDesignation_typeDep());
			assertNotNull(typeDepFound);
			assertEquals(typeDepFound.getDesignation_typeDep(), typeDepFound.getDesignation_typeDep());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			TypeDepense typeDepense = new TypeDepense();
			typeDepense.setDesignation_typeDep("carburant");
			typeDepense = typeDepService.addTypeDepense(typeDepense);
			String inputJson = testParc.mapToJson(typeDepense);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteTypeDepense")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypeDepense typeDepFound = typeDepService.getTypedepenseDes(typeDepense.getDesignation_typeDep());
			assertEquals(null, typeDepFound);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
