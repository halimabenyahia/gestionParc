package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.TypeEntretienRestService;
import com.auth.entitie.TypeEntretien;
import com.auth.entitie.TypePiece;
import com.test.TestParc;
import com.test.TestParcRestController;

public class TypeEntretienTestRestService extends TestParcRestController {
	

	TypeEntretienRestService typeEntretienService ;
	
	// Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;

	TestParc testParc;

	@Test
	@Override
	public void getAllEntityList() {
		try {
			TypeEntretien typeEntretien = new TypeEntretien();
			typeEntretien.setDes_typeEntretien("vidange");
			typeEntretienService.addtypeEntretien(typeEntretien);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/typeEntretiens").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			TypeEntretien[] typeEntretienList = testParc.mapFromJson(content, TypeEntretien[].class);
			assertTrue(typeEntretienList.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			TypeEntretien typeEntretien = new TypeEntretien();
			typeEntretien.setDes_typeEntretien("vidange");
			typeEntretienService.addtypeEntretien(typeEntretien);
			String inputJson = testParc.mapToJson(typeEntretien);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addTypeEntretien")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypeEntretien foundTypeEntretien = typeEntretienService.getTypeEntretienbyDesiTest(typeEntretien.getDes_typeEntretien());
			assertNotNull(foundTypeEntretien);
			assertEquals(foundTypeEntretien.getDes_typeEntretien(), typeEntretien.getDes_typeEntretien());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			TypeEntretien typeEntretien = new TypeEntretien();
			typeEntretien.setDes_typeEntretien("vidange");
			typeEntretienService.addtypeEntretien(typeEntretien);
			typeEntretien.setDes_typeEntretien("huile");
			String inputJson = testParc.mapToJson(typeEntretien);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/editTypeEntretien")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypeEntretien TypeEntretienFound = typeEntretienService.getTypeEntretienbyDesiTest(typeEntretien.getDes_typeEntretien());
			assertNotNull(TypeEntretienFound);
			assertEquals(TypeEntretienFound.getDes_typeEntretien(), typeEntretien.getDes_typeEntretien());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			TypeEntretien typeEntretien = new TypeEntretien();
			typeEntretien.setDes_typeEntretien("vidange");
			typeEntretienService.addtypeEntretien(typeEntretien);
			String inputJson = testParc.mapToJson(typeEntretien);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteTypeEntretien")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypeEntretien TypeEntretienFound = typeEntretienService.getTypeEntretienbyDesiTest(typeEntretien.getDes_typeEntretien());
			assertEquals(null, TypeEntretienFound);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
