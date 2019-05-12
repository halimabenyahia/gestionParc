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

import com.auth.entitie.Energie;
import com.auth.repository.EnergieRepository;

@RestController
@CrossOrigin(origins="*")
public class EnergieRestService {
	
	@Autowired
	private EnergieRepository energieRep ;

	@RequestMapping(value="/energies",method=RequestMethod.GET)
	public List<Energie> getEnergie(){
		return energieRep.findAll();
	}

	@RequestMapping(value="/energieById/{id}",method=RequestMethod.GET)
	public Optional<Energie> getEnergieById(@PathVariable int id){
		return energieRep.findById(id);
	}
	
	@RequestMapping(value="/addEnergie",method=RequestMethod.POST)
	public Energie addEnergie(@RequestBody Energie c){
		return energieRep.save(c);
	}
	
	@RequestMapping(value="/deleteEnergie/{id}",method=RequestMethod.DELETE)
	public boolean supprimerEnergie(@PathVariable int id){
		energieRep.deleteById(id);
		 return true;
	}
	@RequestMapping(value="/editEnergie",method=RequestMethod.PUT)
	public Energie edit(@RequestBody Energie c){
		 return energieRep.save(c);
	}
	
	@RequestMapping(value="/energieByParam/{parametre}",method=RequestMethod.GET)
	public List<Energie> getEnergieParam(@PathVariable String parametre){
		return energieRep.findByParametreEnergie("%"+parametre+"%");
	}
	
	@RequestMapping(value="/energieByDes/{parametre}",method=RequestMethod.GET)
	public Energie getEnergieDes(@PathVariable String parametre){
		return energieRep.findByEnergie("%"+parametre+"%");
	}
	
}
