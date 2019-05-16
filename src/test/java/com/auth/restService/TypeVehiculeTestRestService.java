package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.TypeVehiculeRestService;
import com.auth.entitie.AffectationVehicule;
import com.auth.entitie.TypeVehicule;
import com.test.TestParc;
import com.test.TestParcRestController;

public class TypeVehiculeTestRestService extends TestParcRestController {
	
	TypeVehiculeRestService typeVehiculeService ;
	
	// Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;

	TestParc testParc;

	@Test
	@Override
	public void getAllEntityList() {
		try {
			TypeVehicule typeVehicule = new TypeVehicule();
			typeVehicule.setDes_typeVehicule("camion");;
			typeVehiculeService.addTypeV(typeVehicule);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/typeVehicules").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			TypeVehicule[] typeVehiculeList = testParc.mapFromJson(content, TypeVehicule[].class);
			assertTrue(typeVehiculeList.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			TypeVehicule typeVehicule = new TypeVehicule();
			typeVehicule.setDes_typeVehicule("camion");
			typeVehiculeService.addTypeV(typeVehicule);
			String inputJson = testParc.mapToJson(typeVehicule);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addtypeVehicule")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypeVehicule foundtypeVehicule = typeVehiculeService.getTypevehiculeByDes(typeVehicule.getDes_typeVehicule());
			assertNotNull(foundtypeVehicule);
			assertEquals(foundtypeVehicule.getDes_typeVehicule(), typeVehicule.getDes_typeVehicule());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			TypeVehicule typeVehicule = new TypeVehicule();
			typeVehicule.setDes_typeVehicule("camoin");;
			typeVehicule = typeVehiculeService.addTypeV(typeVehicule);
			typeVehicule.setDes_typeVehicule("grand camoin");
			String inputJson = testParc.mapToJson(typeVehicule);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/editTypeVehicule")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypeVehicule tyypeVehiculeFound = typeVehiculeService.getTypevehiculeByDes(typeVehicule.getDes_typeVehicule());
			assertNotNull(tyypeVehiculeFound);
			assertEquals(tyypeVehiculeFound.getDes_typeVehicule(), typeVehicule.getDes_typeVehicule());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			TypeVehicule typeVehicule = new TypeVehicule();
			typeVehicule.setDes_typeVehicule("camion");
			typeVehicule = typeVehiculeService.addTypeV(typeVehicule);
			String inputJson = testParc.mapToJson(typeVehicule);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteTypeVehicule")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypeVehicule typeVehiculeFound = typeVehiculeService.getTypevehiculeByDes(typeVehicule.getDes_typeVehicule());
			assertEquals(null, typeVehiculeFound);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
