package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.VehiculeRestService;
import com.auth.entitie.Chauffeurs;
import com.auth.entitie.Vehicule;
import com.auth.repository.VehiculeRepository;
import com.test.TestParc;
import com.test.TestParcRestController;

public class VehiculeTestRestService extends TestParcRestController {
	
	
	VehiculeRestService vehiculeService ;
	
	// Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;
	
	TestParc testParc;

	@Test
	@Override
	public void getAllEntityList() {
		try {
			Vehicule vehicule = new Vehicule();
			vehicule.setImmatriculation("100tu1000");
			vehiculeService.addVehicule(vehicule);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/vehicules").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			Vehicule[] vehiculeList = testParc.mapFromJson(content, Vehicule[].class);
			assertTrue(vehiculeList.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	@Test
	@Override
	public void createEntity() {
		try {
			Vehicule vehicule = new Vehicule();
			vehicule.setImmatriculation("160tu1600");
			vehiculeService.addVehicule(vehicule);
			String inputJson = testParc.mapToJson(vehicule);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addVehicule")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Vehicule foundVehicule = vehiculeService.getbyImmatricleV(vehicule.getImmatriculation());
			assertNotNull(foundVehicule);
			assertEquals(foundVehicule.getImmatriculation(), vehicule.getImmatriculation());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			Vehicule vehicule = new Vehicule();
			vehicule.setImmatriculation("160tu1600");
			vehicule = vehiculeService.addVehicule(vehicule);
			vehicule.setImmatriculation("161tu1600");
			String inputJson = testParc.mapToJson(vehicule);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/editVehicules")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Vehicule vehiculeFound = vehiculeService.getbyImmatricleV(vehicule.getImmatriculation());
			assertNotNull(vehiculeFound);
			assertEquals(vehiculeFound.getImmatriculation(), vehicule.getImmatriculation());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			Vehicule vehicule = new Vehicule();
			vehicule.setImmatriculation("160tu1600");
			vehicule = vehiculeService.addVehicule(vehicule);
			String inputJson = testParc.mapToJson(vehicule);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteVehicule")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Vehicule vehiculeFound = vehiculeService.getbyImmatricleV(vehicule.getImmatriculation());
			assertEquals(null, vehiculeFound);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
