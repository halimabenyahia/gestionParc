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

import com.auth.entitie.TypeBoite;
import com.auth.repository.TypeBoiteRepository;

@RestController
@CrossOrigin(origins="*")
public class TypeBoiteRestService {
	
	@Autowired
	private TypeBoiteRepository typeBoiteRep ;
	
	@RequestMapping(value="/typeBoites",method=RequestMethod.GET)
	public List<TypeBoite> getTypeBoite(){
		return typeBoiteRep.findAll();
	}

	@RequestMapping(value="/typeBoiteById/{id}",method=RequestMethod.GET)
	public Optional<TypeBoite> getTypeBoiteById(@PathVariable int id){
		return typeBoiteRep.findById(id);
	}
	
	@RequestMapping(value="/addtypeBoite",method=RequestMethod.POST)
	public TypeBoite addBoite(@RequestBody TypeBoite c){
		return typeBoiteRep.save(c);
	}
	
	@RequestMapping(value="/deleteTypeBoite/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable int id){
		typeBoiteRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editTypeBoite",method=RequestMethod.PUT)
	public TypeBoite edit(@RequestBody TypeBoite c){
		 return typeBoiteRep.save(c);
	}
	
	@RequestMapping(value="/boiteByParam/{parametre}",method=RequestMethod.GET)
	public List<TypeBoite> getBoiteParam(@PathVariable String parametre){
		return typeBoiteRep.findByParametreBoite("%"+parametre+"%");
	}
	
	@RequestMapping(value="/boiteByDes/{parametre}",method=RequestMethod.GET)
	public TypeBoite getBoiteDes(@PathVariable String parametre){
		return typeBoiteRep.findByBoite("%"+parametre+"%");
	}

}
