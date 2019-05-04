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

import com.auth.entitie.Depense;
import com.auth.repository.DepenseRepository;

@RestController
@CrossOrigin(origins="*")
public class DepenseRestService {
	
	@Autowired
	private DepenseRepository depenseRep ;
	
	@RequestMapping(value="/depenses",method=RequestMethod.GET)
	public List<Depense> getDepenses(){
		return depenseRep.findAll();
	}

	@RequestMapping(value="/depenses/{id}",method=RequestMethod.GET)
	public Optional<Depense> getDepenses(@PathVariable int id){
		return depenseRep.findById(id);
	}
	
	@RequestMapping(value="/addDepense",method=RequestMethod.POST)
	public Depense addDepense(@RequestBody Depense c){
		return depenseRep.save(c);
	}
	
	@RequestMapping(value="/deleteDepense/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable int id){
		depenseRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editDepense",method=RequestMethod.PUT)
	public Depense edit(@RequestBody Depense c){
		 return depenseRep.save(c);
	}
	
	
//	@RequestMapping(value="/essai",method=RequestMethod.GET)
//	public Depense getDepenses1(){
//		return depenseRep.findbyfour();
//	}
//	@RequestMapping(value="/essai2",method=RequestMethod.GET)
//	public Depense getDepenses2(){
//		return depenseRep.findByidimm();
//	}
//	@RequestMapping(value="/essai3",method=RequestMethod.GET)
//	public Depense getDepenses3(){
//		return depenseRep.findByPiece();
//	}
//	
//	@RequestMapping(value="/essai4",method=RequestMethod.GET)
//	public Depense getDepenses4(){
//		return depenseRep.findbydepCar();
//	}
	
	

}
