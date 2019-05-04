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

import com.auth.entitie.EntreeStock;
import com.auth.repository.EntreeStockRepository;

@RestController
@CrossOrigin(origins="*")
public class EntreeStockRestService {
	
	@Autowired
	private EntreeStockRepository entreeStockRep ;
	
	@RequestMapping(value="/entreeStocks",method=RequestMethod.GET)
	public List<EntreeStock> getAllEntreestock(){
		return entreeStockRep.findAll();
	}

	@RequestMapping(value="/entreeStockById/{id}",method=RequestMethod.GET)
	public Optional<EntreeStock> getByIdEntreestock(@PathVariable int id){
		return entreeStockRep.findById(id);
	}
	
	@RequestMapping(value="/addEntreeStock",method=RequestMethod.POST)
	public EntreeStock addEntreStock(@RequestBody EntreeStock c){
		return entreeStockRep.save(c);
	}
	
	@RequestMapping(value="/deleteEntreStock/{id}",method=RequestMethod.DELETE)
	public boolean deleteVehicule(@PathVariable int id){
		entreeStockRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editEntreeStock",method=RequestMethod.PUT)
	public EntreeStock editEntreStock(@RequestBody EntreeStock c){
		 return entreeStockRep.save(c);
	}

}
