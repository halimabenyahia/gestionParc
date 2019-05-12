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

import com.auth.entitie.Marque;
import com.auth.repository.MarqueRepository;

@RestController
@CrossOrigin(origins="*")
public class MarqueRestService {
	
	
	@Autowired
	private MarqueRepository marqueRep ;
	
	@RequestMapping(value="/marques",method=RequestMethod.GET)
	public List<Marque> getMarques(){
		return marqueRep.findAll();
	}

	@RequestMapping(value="/marqueById/{id}",method=RequestMethod.GET)
	public Optional<Marque> getMarquesById(@PathVariable int id){
		return marqueRep.findById(id);
	}
	
	@RequestMapping(value="/addMarque",method=RequestMethod.POST)
	public Marque addMarque(@RequestBody Marque c){
		return marqueRep.save(c);
	}
	
	@RequestMapping(value="/deleteMarque/{id}",method=RequestMethod.DELETE)
	public boolean supprimerMarque(@PathVariable int id){
		marqueRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editMarque",method=RequestMethod.PUT)
	public Marque editMarque(@RequestBody Marque c){
		 return marqueRep.save(c);
	}
	
	@RequestMapping(value="/marqueByParam/{parametre}",method=RequestMethod.GET)
	public List<Marque> getMarqueParam(@PathVariable String parametre){
		return marqueRep.findByParametreM("%"+parametre+"%");
	}
	
	@RequestMapping(value="/marqueBydesing/{parametre}",method=RequestMethod.GET)
	public Marque getMarqueDes(@PathVariable String parametre){
		return marqueRep.findByDesignation("%"+parametre+"%");
	}
	
	
//	@RequestMapping(value="/marqueByMo",method=RequestMethod.GET)
//	public Marque getMarquesm(){
//		return marqueRep.findbyModele();
//	}

}
