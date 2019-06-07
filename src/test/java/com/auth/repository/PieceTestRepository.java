package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.Modele;
import com.auth.entitie.Piece;
import com.test.TestParcRepository;

@SpringBootTest
@Transactional
public class PieceTestRepository extends TestParcRepository{
	
	@Autowired
	PieceRepository pieceRep ;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		Piece savedPiece=new Piece() ;
		savedPiece.setDes_piece("roue");
		savedPiece=pieceRep.save(savedPiece);
		Piece foundPiece = pieceRep.findbyDesignation(savedPiece.getDes_piece());
		assertNotNull(foundPiece);
		assertEquals( foundPiece.getId_piece(), savedPiece.getId_piece());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		Piece savedPiece=new Piece() ;
		savedPiece.setDes_piece("roue");
		savedPiece=pieceRep.save(savedPiece);
		savedPiece.setDes_piece("rouexx");
		savedPiece=pieceRep.save(savedPiece);
		Piece foundPiece = pieceRep.getOne(savedPiece.getId_piece());
		assertEquals(foundPiece.getDes_piece(), savedPiece.getDes_piece());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		Piece savedPiece=new Piece() ;
		savedPiece.setDes_piece("roue");
		savedPiece=pieceRep.save(savedPiece);
		pieceRep.delete(savedPiece);
		Piece foundPiece = pieceRep.findbyDesignation(savedPiece.getDes_piece());
		assertEquals(null, foundPiece);
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		Piece savedPiece=new Piece() ;
		savedPiece.setDes_piece("roue");
		savedPiece=pieceRep.save(savedPiece);
		List<Piece> list = pieceRep.findAll();
		assertEquals(1, list.size());
		
	}
	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		Piece savedPiece=new Piece() ;
		savedPiece.setDes_piece("roue");
		savedPiece=pieceRep.save(savedPiece);
		savedPiece.setDes_piece("rouex");
		Piece foundPiece = pieceRep.getOne(savedPiece.getId_piece());
		assertEquals(foundPiece.getId_piece(), savedPiece.getId_piece());
		
	}

}
