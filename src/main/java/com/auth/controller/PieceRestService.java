package com.auth.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth.entitie.Piece;
import com.auth.repository.PieceRepository;

@RestController
@CrossOrigin(origins="*")
public class PieceRestService {
	
	@Autowired
	private PieceRepository pieceRep ;
	
	
	@RequestMapping(value="/pieces",method=RequestMethod.GET)
	public List<Piece> getAllPiece(){
		return pieceRep.findAll();
	}

	@RequestMapping(value="/pieceById/{id}",method=RequestMethod.GET)
	public Optional<Piece> getByIdPiece(@PathVariable int id){
		return pieceRep.findById(id);
	}
	
	@RequestMapping(value="/addPiece",method=RequestMethod.POST)
	public Piece addPiece(@RequestBody Piece c){
		return pieceRep.save(c);
	}
	
	@RequestMapping(value="/deletePiece/{id}",method=RequestMethod.DELETE)
	public boolean deletePiece(@PathVariable int id){
		pieceRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editPiece",method=RequestMethod.PUT)
	public Piece editPiece(@RequestBody Piece c){
		 return pieceRep.save(c);
	}
	
//	@RequestMapping(value="/pieceBytype",method=RequestMethod.GET)
//	public Piece getByIdPiecet(){
//		return pieceRep.findbyTypeP();
//	}
//	
//	@RequestMapping(value="/piecesbyent",method=RequestMethod.GET)
//	public Piece getAllPiece1(){
//		return pieceRep.findByEntree();
//	}
//	@RequestMapping(value="/piecesbysort",method=RequestMethod.GET)
//	public Piece getAllPiece2(){
//		return pieceRep.findBySortie();
//	}

}
