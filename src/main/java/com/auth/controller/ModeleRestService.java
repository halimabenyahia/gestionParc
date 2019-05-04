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
import com.auth.repository.ModeleRepository;

@RestController
@CrossOrigin(origins="*")
public class ModeleRestService {
	
	@Autowired
	private ModeleRepository modeleRep ;
	
	@RequestMapping(value="/modeles",method=RequestMethod.GET)
	public List<Modele> getModeles(){
		return modeleRep.findAll();
	}

	@RequestMapping(value="/modeleById/{id}",method=RequestMethod.GET)
	public Optional<Modele> getModeleById(@PathVariable int id){
		return modeleRep.findById(id);
	}
	
	@RequestMapping(value="/addModele",method=RequestMethod.POST)
	public Modele addModele(@RequestBody Modele c){
		return modeleRep.save(c);
	}
	
	@RequestMapping(value="/deleteModele/{id}",method=RequestMethod.DELETE)
	public boolean supprimerModele(@PathVariable int id){
		modeleRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editModele",method=RequestMethod.PUT)
	public Modele editModele(@RequestBody Modele c){
		 return modeleRep.save(c);
	}
	
	
	@RequestMapping(value="/modeleByParam/{parametre}",method=RequestMethod.GET)
	public List<Modele> getModeleParam(@PathVariable String parametre){
		return modeleRep.findByParamModel("%"+parametre+"%");
	}

}
