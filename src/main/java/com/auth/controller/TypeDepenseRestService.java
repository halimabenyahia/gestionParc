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

import com.auth.entitie.TypeDepense;
import com.auth.repository.TypeDepenseRepository;

@RestController
@CrossOrigin(origins="*")
public class TypeDepenseRestService  {
	
	@Autowired
	private TypeDepenseRepository typeDepenseRep ;
	
	@RequestMapping(value="/typeDepenses",method=RequestMethod.GET)
	public List<TypeDepense> getAllTypeDepense(){
		return typeDepenseRep.findAll();
	}

	@RequestMapping(value="/typeDepenseById/{id}",method=RequestMethod.GET)
	public Optional<TypeDepense> getByIdTypeDepense(@PathVariable int id){
		return typeDepenseRep.findById(id);
	}
	
	@RequestMapping(value="/addTypeDepense",method=RequestMethod.POST)
	public TypeDepense addTypeDepense(@RequestBody TypeDepense c){
		return typeDepenseRep.save(c);
	}
	
	@RequestMapping(value="/deleteTypeDepense/{id}",method=RequestMethod.DELETE)
	public boolean deleteTypeDepense(@PathVariable int id){
		typeDepenseRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editTypeDepense",method=RequestMethod.PUT)
	public TypeDepense editTypeDepense(@RequestBody TypeDepense c){
		 return typeDepenseRep.save(c);
	}

}
