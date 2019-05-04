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

import com.auth.entitie.DepenseCarburant;
import com.auth.repository.DepenseCarburantRepository;

@RestController
@CrossOrigin(origins="*")
public class DepenseCarburantRestService {
	
	@Autowired
	private DepenseCarburantRepository depenseCarbRep ;
	
	@RequestMapping(value="/depenseCarburants",method=RequestMethod.GET)
	public List<DepenseCarburant> getAllDepensesCar(){
		return depenseCarbRep.findAll();
	}

	@RequestMapping(value="/depenseCarById/{id}",method=RequestMethod.GET)
	public Optional<DepenseCarburant> getByIddepenseCar(@PathVariable int id){
		return depenseCarbRep.findById(id);
	}
	
	@RequestMapping(value="/addDepenseCar",method=RequestMethod.POST)
	public DepenseCarburant addDepenseCar(@RequestBody DepenseCarburant c){
		return depenseCarbRep.save(c);
	}
	
	@RequestMapping(value="/deleteDepenseCar/{id}",method=RequestMethod.DELETE)
	public boolean deletedepenseCar(@PathVariable int id){
		depenseCarbRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editdepenseCar",method=RequestMethod.PUT)
	public DepenseCarburant editDepenseCar(@RequestBody DepenseCarburant c){
		 return depenseCarbRep.save(c);
	}
	

}
