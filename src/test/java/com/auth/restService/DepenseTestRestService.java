package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

	@Override
	public void getAllEntityList() {
		try {
			Depense depense = new Depense();
		//	depense.setDate_depense(2018/02/02);
		//	energieService.addEnergie(energie);
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

	@Override
	public void createEntity() {
		// TODO Auto-generated method stub
		
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
