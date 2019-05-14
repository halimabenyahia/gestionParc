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

import com.auth.entitie.Vehicule;
import com.auth.repository.VehiculeRepository;

@RestController
@CrossOrigin(origins="*")
public class VehiculeRestService {
	
	@Autowired
	private VehiculeRepository vehiculeRep ;
	
	@RequestMapping(value="/vehicules",method=RequestMethod.GET)
	
	public List<Vehicule> getAllVehicule(){
		return vehiculeRep.findAll();
	}

	@RequestMapping(value="/vehiculeById/{id}",method=RequestMethod.GET)
	public Optional<Vehicule> getByIdVehicule(@PathVariable Integer id){
		return vehiculeRep.findById(id);
	}
	
	@RequestMapping(value="/addVehicule",method=RequestMethod.POST)
	public Vehicule addVehicule(@RequestBody Vehicule c){
		return vehiculeRep.save(c);
	}
	
	@RequestMapping(value="/deleteVehicule/{id}",method=RequestMethod.DELETE)
	public boolean deleteVehicule(@PathVariable Integer id){
		vehiculeRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editVehicules",method=RequestMethod.PUT)
	public Vehicule editVehicule(@RequestBody Vehicule c){
		
		 return vehiculeRep.save(c);
	
	}
	
	@CrossOrigin(origins="*")	
	@RequestMapping(value="/vehiculebyImmatriculation/{chaine}",method=RequestMethod.GET)
	public List<Vehicule> getbyImmatricle(@PathVariable String chaine) {
		System.out.println("in getByMat");
		return vehiculeRep.findByImmatriculation("%"+chaine+"%");
	}
	
	@RequestMapping(value="/vehiculebyImmatriculationV/{chaine}",method=RequestMethod.GET)
	public Vehicule getbyImmatricleV(@PathVariable String chaine) {
		System.out.println("in getByMat");
		return vehiculeRep.findByImmV("%"+chaine+"%");
	}
}
