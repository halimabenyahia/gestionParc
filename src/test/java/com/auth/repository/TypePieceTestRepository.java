package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.TypePiece;
import com.test.TestParcRepository;

@SpringBootTest
@Transactional
public class TypePieceTestRepository extends TestParcRepository {
	
	@Autowired
	TypePieceRepository typePieceRep ;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		TypePiece savedTypePiece=new TypePiece() ;
		savedTypePiece.setDes_typePiece("piece detachee");
		savedTypePiece=typePieceRep.save(savedTypePiece);
		TypePiece foundTypePiece = typePieceRep.findByTypePiece(savedTypePiece.getDes_typePiece());
		assertNotNull(foundTypePiece);
		assertEquals( foundTypePiece.getId_typePiece(), savedTypePiece.getId_typePiece());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		TypePiece savedTypePiece=new TypePiece() ;
		savedTypePiece.setDes_typePiece("piece detachee");
		savedTypePiece=typePieceRep.save(savedTypePiece);
		savedTypePiece.setDes_typePiece("piece rechange");
		savedTypePiece=typePieceRep.save(savedTypePiece);
		TypePiece foundTypePiece = typePieceRep.getOne(savedTypePiece.getId_typePiece());
		assertEquals(foundTypePiece.getDes_typePiece(), savedTypePiece.getDes_typePiece());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		TypePiece savedTypePiece=new TypePiece() ;
		savedTypePiece.setDes_typePiece("piece detachee");
		savedTypePiece=typePieceRep.save(savedTypePiece);
		typePieceRep.delete(savedTypePiece);
		TypePiece foundTypePiece = typePieceRep.findByTypePiece(savedTypePiece.getDes_typePiece());
		assertEquals(null, foundTypePiece);
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		TypePiece savedTypePiece=new TypePiece() ;
		savedTypePiece.setDes_typePiece("piece detachee");
		savedTypePiece=typePieceRep.save(savedTypePiece);
		List<TypePiece> list = typePieceRep.findAll();
		assertEquals(1, list.size());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		TypePiece savedTypePiece=new TypePiece() ;
		savedTypePiece.setDes_typePiece("piece detachee");
		savedTypePiece=typePieceRep.save(savedTypePiece);
		savedTypePiece.setDes_typePiece("piece ");
		TypePiece foundTypePiece = typePieceRep.getOne(savedTypePiece.getId_typePiece());
		assertEquals(foundTypePiece.getId_typePiece(), savedTypePiece.getId_typePiece());
		
	}

}
