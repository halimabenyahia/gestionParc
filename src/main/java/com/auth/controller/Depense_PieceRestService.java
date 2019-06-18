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

import com.auth.entitie.Chauffeurs;
import com.auth.entitie.Depense;
import com.auth.entitie.Depense_Piece;
import com.auth.repository.Depense_PieceRepository;
import com.auth.service.DepensePieceService;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class Depense_PieceRestService {

	
	@Autowired
	Depense_PieceRepository depensePieceRep ;
	
	@Autowired
	DepensePieceService depensePieceService ;
	
	@RequestMapping(value="/depensePieceList",method=RequestMethod.GET)
	public List<Depense_Piece> getDepensePieceList(){
		return depensePieceRep.findAll();
	}

	@RequestMapping(value="/depensePieceById/{id}",method=RequestMethod.GET)
	public Optional<Depense_Piece> getDepensePieceById(@PathVariable int id){
		return depensePieceRep.findById(id);
	}
	
	@RequestMapping(value="/adddepensePiece",method=RequestMethod.POST)
	public List<Depense_Piece> addDepensePiece(@RequestBody List<Depense_Piece> c){
		return depensePieceRep.saveAll(c);
	}
	
	@RequestMapping(value="/deletedepensePiece/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable int id){
		depensePieceRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editdepensePiece",method=RequestMethod.PUT)
	public Depense_Piece edit(@RequestBody Depense_Piece c){
		 return depensePieceRep.save(c);
	}
	
//	@RequestMapping(value="/affiche",method=RequestMethod.GET)
//	public List<Depense_Piece> getList(){
//		return depensePieceService.getResult(); 
//	}
	
	@RequestMapping(value="/ajout",method=RequestMethod.POST)
	public List<Depense_Piece> add (@RequestBody Depense d , @RequestBody List<Depense_Piece> dp) {
		return depensePieceService.add(d,dp);
	}
	
	@RequestMapping(value="/totalht",method=RequestMethod.GET)
	public Long totalHT () {
		return depensePieceRep.getTotalHT();
	}
	@RequestMapping(value="/totalttc",method=RequestMethod.GET)
	public Long totalTTC () {
		return depensePieceRep.getTotalTTC();
	}
}
