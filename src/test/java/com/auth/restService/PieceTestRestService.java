package com.auth.restService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.auth.controller.PieceRestService;
import com.auth.entitie.Piece;
import com.auth.entitie.TypeBoite;
import com.test.TestParc;
import com.test.TestParcRestController;

public class PieceTestRestService extends TestParcRestController {
	
	PieceRestService pieceService ;
	
	// Donne accès au résultat d'une requête exécutée.
	private MvcResult mvcResult;

	TestParc testParc;

	@Test
	@Override
	public void getAllEntityList() {
		try {
			Piece piece = new Piece();
			piece.setDes_piece("retroviseur");
			pieceService.addPiece(piece);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get("/pieces").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();

			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			Piece[] pieceList = testParc.mapFromJson(content, Piece[].class);
			assertTrue(pieceList.length > 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void createEntity() {
		try {
			Piece piece = new Piece();
			piece.setDes_piece("roue");
			pieceService.addPiece(piece);
			String inputJson = testParc.mapToJson(piece);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post("/addPiece")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Piece foundpiece = pieceService.getbyDesignation(piece.getDes_piece());
			assertNotNull(foundpiece);
			assertEquals(foundpiece.getDes_piece(), piece.getDes_piece());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void updateEntity() {
		try {
			Piece piece = new Piece();
			piece.setDes_piece("roue");
			piece = pieceService.addPiece(piece);
			piece.setDes_piece("far");
			String inputJson = testParc.mapToJson(piece);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put("/editPiece")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Piece pieceFound = pieceService.getbyDesignation(piece.getDes_piece());
			assertNotNull(pieceFound);
			assertEquals(pieceFound.getDes_piece(), piece.getDes_piece());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	@Override
	public void deleteEntity() {
		try {
			Piece piece = new Piece();
			piece.setDes_piece("retroviseur");
			piece = pieceService.addPiece(piece);
			String inputJson = testParc.mapToJson(piece);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/deletePiece")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			Piece pieceFound = pieceService.getbyDesignation(piece.getDes_piece());
			assertEquals(null, pieceFound);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
