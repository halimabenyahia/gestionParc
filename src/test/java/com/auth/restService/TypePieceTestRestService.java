package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.TypePieceRestService;
import com.auth.entitie.TypeBoite;
import com.auth.entitie.TypePiece;
import com.test.TestParc;
import com.test.TestParcRestController;

public class TypePieceTestRestService extends TestParcRestController {
	
	TypePieceRestService typePieceService;
	

	// Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;

	TestParc testParc;

	@Test
	@Override
	public void getAllEntityList() {
		try {
			TypePiece typePiece = new TypePiece();
			typePiece.setDes_typePiece("piece de rechange");
			typePieceService.addTypePiece(typePiece);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/typepieces").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			TypePiece[] typePieceList = testParc.mapFromJson(content, TypePiece[].class);
			assertTrue(typePieceList.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			TypePiece typePiece = new TypePiece();
			typePiece.setDes_typePiece("piece detachee");
			typePieceService.addTypePiece(typePiece);
			String inputJson = testParc.mapToJson(typePiece);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addTypePiece")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypePiece foundtypeP = typePieceService.getTypePiecebyDes(typePiece.getDes_typePiece());
			assertNotNull(foundtypeP);
			assertEquals(foundtypeP.getDes_typePiece(), typePiece.getDes_typePiece());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			TypePiece typePiece = new TypePiece();
			typePiece.setDes_typePiece("piece detachee");
			typePiece = typePieceService.addTypePiece(typePiece);
			typePiece.setDes_typePiece("accessoir");
			String inputJson = testParc.mapToJson(typePiece);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/editTypePiece")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypePiece typePieceFound = typePieceService.getTypePiecebyDes(typePiece.getDes_typePiece());
			assertNotNull(typePieceFound);
			assertEquals(typePieceFound.getDes_typePiece(), typePiece.getDes_typePiece());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			TypePiece typePiece = new TypePiece();
			typePiece.setDes_typePiece("piece detachee");
			typePiece = typePieceService.addTypePiece(typePiece);
			String inputJson = testParc.mapToJson(typePiece);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deleteTypePiece")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			TypePiece typePieceFound = typePieceService.getTypePiecebyDes(typePiece.getDes_typePiece());
			assertEquals(null, typePieceFound);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
