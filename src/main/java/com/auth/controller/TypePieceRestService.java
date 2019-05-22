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

import com.auth.entitie.Modele;
import com.auth.entitie.TypePiece;
import com.auth.repository.TypePieceRepository;

@RestController
@CrossOrigin(origins="*")
public class TypePieceRestService {
	
	@Autowired
	private TypePieceRepository typePieceRep ;
	
	@RequestMapping(value="/typepieces",method=RequestMethod.GET)
	public List<TypePiece> getAllTypePiece(){
		return typePieceRep.findAll();
	}

	@RequestMapping(value="/TypepieceById/{id}",method=RequestMethod.GET)
	public Optional<TypePiece> getByIdtypePiece(@PathVariable int id){
		return typePieceRep.findById(id);
	}
	
	@RequestMapping(value="/addTypePiece",method=RequestMethod.POST)
	public TypePiece addTypePiece(@RequestBody TypePiece c){
		return typePieceRep.save(c);
	}
	
	@RequestMapping(value="/deleteTypePiece/{id}",method=RequestMethod.DELETE)
	public boolean deletetypePiece(@PathVariable int id){
		typePieceRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editTypePiece",method=RequestMethod.PUT)
	public TypePiece edittypePiece(@RequestBody TypePiece c){
		 return typePieceRep.save(c);
	}
	
	@RequestMapping(value="/typePieceByParam/{parametre}",method=RequestMethod.GET)
	public List<TypePiece> getTypePieceParam(@PathVariable String parametre){
		return typePieceRep.findByTypePieceParam("%"+parametre+"%");
	}
	

}
