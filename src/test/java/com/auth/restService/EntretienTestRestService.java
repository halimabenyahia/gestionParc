package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.ProgrammeEntretienRestService;
import com.auth.entitie.Energie;
import com.auth.entitie.ProgrammeEntretien;
import com.test.TestParc;
import com.test.TestParcRestController;

public class EntretienTestRestService extends TestParcRestController {
	
	ProgrammeEntretienRestService entretienService ;
	
	// Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;

	TestParc testParc;

	@Test
	@Override
	public void getAllEntityList() {
		try {
			ProgrammeEntretien programmeEntretien = new ProgrammeEntretien();
			programmeEntretien.setDescription("entretien1");
			entretienService.addProgramme(programmeEntretien);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/programmeEntretiens").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			ProgrammeEntretien[] ListProgrammeEntretien = testParc.mapFromJson(content, ProgrammeEntretien[].class);
			assertTrue(ListProgrammeEntretien.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			ProgrammeEntretien programmeEntretien = new ProgrammeEntretien();
			programmeEntretien.setDescription("entretien1");
			entretienService.addProgramme(programmeEntretien);
			String inputJson = testParc.mapToJson(programmeEntretien);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addProgramme")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			ProgrammeEntretien foundProgrammeEntretien = entretienService.getEntretienByDes(programmeEntretien.getDescription());
			assertNotNull(foundProgrammeEntretien);
			assertEquals(foundProgrammeEntretien.getDescription(), programmeEntretien.getDescription());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			ProgrammeEntretien programmeEntretien = new ProgrammeEntretien();
			programmeEntretien.setDescription("entretien1");
			entretienService.addProgramme(programmeEntretien);
			programmeEntretien.setDescription("entretien1");
			String inputJson = testParc.mapToJson(programmeEntretien);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/editProgramEnt")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			ProgrammeEntretien FoundProgrammeEntretien = entretienService.getEntretienByDes(programmeEntretien.getDescription());
			assertNotNull(FoundProgrammeEntretien);
			assertEquals(FoundProgrammeEntretien.getDescription(), programmeEntretien.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			ProgrammeEntretien programmeEntretien = new ProgrammeEntretien();
			programmeEntretien.setDescription("entretien1");
			entretienService.addProgramme(programmeEntretien);
			String inputJson = testParc.mapToJson(programmeEntretien);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteProgrammeEnt")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			ProgrammeEntretien FoundProgrammeEntretien = entretienService.getEntretienByDes(programmeEntretien.getDescription());
			assertEquals(null, FoundProgrammeEntretien);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
