package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.AffectationVehiculeRestService;
import com.auth.entitie.AffectationVehicule;
import com.auth.entitie.Chauffeurs;
import com.test.TestParc;
import com.test.TestParcRestController;

@SpringBootTest
public class AffectationTestRestService extends TestParcRestController {
	
	AffectationVehiculeRestService affectationService ;
	
	// Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;

	TestParc testParc;


	@Test
	@Override
	public void getAllEntityList() {
		try {
			AffectationVehicule affectation = new AffectationVehicule();
			affectation.setDes_affectation("service");
			affectationService.addAffectation(affectation);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/affectations").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			AffectationVehicule[] affectationList = testParc.mapFromJson(content, AffectationVehicule[].class);
			assertTrue(affectationList.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			AffectationVehicule affectation = new AffectationVehicule();
			affectation.setDes_affectation("transport lourd");;
			affectationService.addAffectation(affectation);
			String inputJson = testParc.mapToJson(affectation);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addAffectation")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			AffectationVehicule foundAffectation = affectationService.getAffectationObj(affectation.getDes_affectation());
			assertNotNull(foundAffectation);
			assertEquals(foundAffectation.getDes_affectation(), affectation.getDes_affectation());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			AffectationVehicule affectation = new AffectationVehicule();
			affectation.setDes_affectation("transport lourd");
			affectation = affectationService.addAffectation(affectation);
			affectation.setDes_affectation("transport l");;
			String inputJson = testParc.mapToJson(affectation);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/editAffectation")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			AffectationVehicule affectationFound = affectationService.getAffectationObj(affectation.getDes_affectation());
			assertNotNull(affectationFound);
			assertEquals(affectationFound.getDes_affectation(), affectation.getDes_affectation());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			AffectationVehicule affectation = new AffectationVehicule();
			affectation.setDes_affectation("transport l");;
			affectation = affectationService.addAffectation(affectation);
			String inputJson = testParc.mapToJson(affectation);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteAffectation")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			AffectationVehicule affectationFound = affectationService.getAffectationObj(affectation.getDes_affectation());
			assertEquals(null, affectationFound);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
