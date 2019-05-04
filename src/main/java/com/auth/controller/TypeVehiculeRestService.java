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

import com.auth.entitie.TypeVehicule;
import com.auth.repository.TypeVehiculeRepository;

@RestController
@CrossOrigin(origins="*")
public class TypeVehiculeRestService {
	
	@Autowired
	private TypeVehiculeRepository typeVehiculeRep ;
	
	@RequestMapping(value="/typeVehicules",method=RequestMethod.GET)
	public List<TypeVehicule> getTypeVehicule(){
		return typeVehiculeRep.findAll();
	}

	@RequestMapping(value="/typeVehiculeById/{id}",method=RequestMethod.GET)
	public Optional<TypeVehicule> getTypeVehiculeById(@PathVariable int id){
		return typeVehiculeRep.findById(id);
	}
	
	@RequestMapping(value="/addtypeVehicule",method=RequestMethod.POST)
	public TypeVehicule addTypeV(@RequestBody TypeVehicule c){
		return typeVehiculeRep.save(c);
	}
	
	@RequestMapping(value="/deleteTypeVehicule/{id}",method=RequestMethod.DELETE)
	public boolean supprimerTypeV(@PathVariable int id){
		typeVehiculeRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editTypeVehicule",method=RequestMethod.PUT)
	public TypeVehicule edittypeVehicule(@RequestBody TypeVehicule c){
		 return typeVehiculeRep.save(c);
	}
	
	@RequestMapping(value="/typevehiculeByParam/{parametre}",method=RequestMethod.GET)
	public List<TypeVehicule> getTypevehiculeParam(@PathVariable String parametre){
		return typeVehiculeRep.findByTypeVehiculeParam("%"+parametre+"%");
	}
	

}
