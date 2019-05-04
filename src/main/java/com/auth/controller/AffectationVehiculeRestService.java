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

import com.auth.entitie.AffectationVehicule;
import com.auth.repository.AffectationVehiculeRepository;

@RestController
@CrossOrigin(origins="*")
public class AffectationVehiculeRestService {
	
	@Autowired
	private AffectationVehiculeRepository affectationVehiculeRep ;
	
	
	@RequestMapping(value="/affectations",method=RequestMethod.GET)
	public List<AffectationVehicule> getAffectation(){
		return affectationVehiculeRep.findAll();
	}

	@RequestMapping(value="/affectationById/{id}",method=RequestMethod.GET)
	public Optional<AffectationVehicule> getAffectationById(@PathVariable int id){
		return affectationVehiculeRep.findById(id);
	}
	
	@RequestMapping(value="/addAffectation",method=RequestMethod.POST)
	public AffectationVehicule addAffectation(@RequestBody AffectationVehicule c){
		return affectationVehiculeRep.save(c);
	}
	
	@RequestMapping(value="/deleteAffectation/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable int id){
		affectationVehiculeRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editAffectation",method=RequestMethod.PUT)
	public AffectationVehicule edit(@RequestBody AffectationVehicule c){
		 return affectationVehiculeRep.save(c);
	}


	@RequestMapping(value="/affectationByParam/{parametre}",method=RequestMethod.GET)
	public List<AffectationVehicule> getAffectationParam(@PathVariable String parametre){
		return affectationVehiculeRep.findByAffectationParam("%"+parametre+"%");
	}

}
