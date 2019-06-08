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

import com.auth.entitie.TypeEntretien;
import com.auth.entitie.TypePiece;
import com.auth.repository.TypeEntretienRepository;

@RestController
@CrossOrigin(origins="*")
public class TypeEntretienRestService {
	
	@Autowired
	private TypeEntretienRepository typeEntretienRep ;
	

	@RequestMapping(value="/typeEntretiens",method=RequestMethod.GET)
	public List<TypeEntretien> getAlltypeEntretiens(){
		return typeEntretienRep.findAll();
	}

	@RequestMapping(value="/typeEntretienById/{id}",method=RequestMethod.GET)
	public Optional<TypeEntretien> getByIdTypeEntretien(@PathVariable int id){
		return typeEntretienRep.findById(id);
	}
	
	@RequestMapping(value="/addTypeEntretien",method=RequestMethod.POST)
	public TypeEntretien addtypeEntretien(@RequestBody TypeEntretien c){
		return typeEntretienRep.save(c);
	}
	
	@RequestMapping(value="/deleteTypeEntretien/{id}",method=RequestMethod.DELETE)
	public boolean deleteTypeEntretien(@PathVariable int id){
		typeEntretienRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editTypeEntretien",method=RequestMethod.PUT)
	public TypeEntretien editTypeEntretien(@RequestBody TypeEntretien c){
		 return typeEntretienRep.save(c);
	}
	
	@RequestMapping(value="/typeEntretienByDes/{parametre}",method=RequestMethod.GET)
	public List<TypeEntretien> getTypeEntretienbyDes(@PathVariable String parametre){
		return typeEntretienRep.findByTypeEntretien("%"+parametre+"%");
	}
	
	@RequestMapping(value="/typeEntretienByDesTest/{parametre}",method=RequestMethod.GET)
	public TypeEntretien getTypeEntretienbyDesiTest(@PathVariable String parametre){
		return typeEntretienRep.findByTypeEntretienDes("%"+parametre+"%");
	}
	
}
