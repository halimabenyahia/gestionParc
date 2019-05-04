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

import com.auth.entitie.EntretienFrequence;
import com.auth.repository.EntretienFrequenceRepository;

@RestController
@CrossOrigin(origins="*")
public class EntretienFrequenceRestService {
	
	@Autowired
	private EntretienFrequenceRepository entretienFreqRep ;
	
	@RequestMapping(value="/entretienFrequence",method=RequestMethod.GET)
	public List<EntretienFrequence> getAllEntretiensfrequence(){
		return entretienFreqRep.findAll();
	}

	@RequestMapping(value="/EntretienFrequenceById/{id}",method=RequestMethod.GET)
	public Optional<EntretienFrequence> getByIdEntretienFreq(@PathVariable int id){
		return entretienFreqRep.findById(id);
	}
	
	@RequestMapping(value="/addEntretienFreq",method=RequestMethod.POST)
	public EntretienFrequence addEntretienFreq(@RequestBody EntretienFrequence c){
		return entretienFreqRep.save(c);
	}
	
	@RequestMapping(value="/deleteEntretienFreq/{id}",method=RequestMethod.DELETE)
	public boolean deleteEntretienFreq(@PathVariable int id){
		entretienFreqRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editEntretienFreq",method=RequestMethod.PUT)
	public EntretienFrequence editEntretienFreq(@RequestBody EntretienFrequence c){
		 return entretienFreqRep.save(c);
	}
	
//	@RequestMapping(value="/EntretienFreqprog",method=RequestMethod.GET)
//	public EntretienFrequence getByIdEntretienFreqPro(){
//		return entretienFreqRep.findbyprogFreq();
//	}
//	

}
