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

import com.auth.entitie.Assurance;
import com.auth.repository.AssuranceRepository;

@RestController
@CrossOrigin(origins="*")
public class AssuranceRestService {
	
	@Autowired
	private AssuranceRepository assuranceRep ;
	
	@RequestMapping(value="/Assurance",method=RequestMethod.GET)
	public List<Assurance> getAssurrance(){
		return assuranceRep.findAll();
	}

	@RequestMapping(value="/AssuranceByid/{id}",method=RequestMethod.GET)
	public Optional<Assurance> getAssuranceById(@PathVariable int id){
		return assuranceRep.findById(id);
	}
	
	@RequestMapping(value="/addAssurance",method=RequestMethod.POST)
	public Assurance addAssurance(@RequestBody Assurance c){
		return assuranceRep.save(c);
	}
	
	@RequestMapping(value="/deleteAssurance/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable int id){
		assuranceRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editAssurance",method=RequestMethod.PUT)
	public Assurance editAssurance(@RequestBody Assurance c){
		 return assuranceRep.save(c);
	}
	
	@RequestMapping(value="/assuranceByParam/{parametre}",method=RequestMethod.GET)
	public List<Assurance> getAssuranceParam(@PathVariable String parametre){
		return assuranceRep.findByParametreAssurance("%"+parametre+"%");
	}

	@RequestMapping(value="/assuranceByCompagnie/{parametre}",method=RequestMethod.GET)
	public Assurance getAssuranceCompagnie(@PathVariable String parametre){
		return assuranceRep.findByAssurance("%"+parametre+"%");
	}
}
