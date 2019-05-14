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
import com.auth.entitie.DepenseResponse;
import com.auth.repository.DepenseRepository;
import com.auth.service.DepenseService;

@RestController
@CrossOrigin(origins="*")
public class DepenseRestService {
	
	@Autowired
	private DepenseRepository depenseRep ;
	
	@Autowired
	private DepenseService depenseService ;
	
	@RequestMapping(value="/depensesSum",method=RequestMethod.GET)
	public List<DepenseResponse> getSumDepenses(){
		return depenseService.listeDepenses(); 
	}
	
	@RequestMapping(value="/listdepenses",method=RequestMethod.GET)
	public List<Depense> getDepenses(){
		return depenseRep.findAll();
	}

	@RequestMapping(value="/depenses/{id}",method=RequestMethod.GET)
	public Optional<Depense> getDepensesById(@PathVariable int id){
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
	
	
	@RequestMapping(value="/depenseByimm/{parametre}",method=RequestMethod.GET)
	public Iterable<Depense> getDepenseByImm(@PathVariable String parametre){
		return depenseRep.getbyImmatricul("%"+parametre);
	}
	
	@RequestMapping(value="/sumdepenseByimm/{parametre}",method=RequestMethod.GET)
	public List<DepenseResponse> getSumDepenceByImm(@PathVariable String parametre){
		return depenseService.oneDepense("%"+parametre);
	}
}
