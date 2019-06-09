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

import com.auth.entitie.Energie;
import com.auth.entitie.ProgrammeEntretien;
import com.auth.repository.ProgrammeEntretienRepository;

@RestController
@CrossOrigin(origins="*")
public class ProgrammeEntretienRestService {
	
	@Autowired
	private ProgrammeEntretienRepository progEntreRep  ;
	
	
	@RequestMapping(value="/programmeEntretiens",method=RequestMethod.GET)
	public List<ProgrammeEntretien> getProgEntretiens(){
		return progEntreRep.findAll();
	}

	@RequestMapping(value="/programmeEntretiens/{id}",method=RequestMethod.GET)
	public Optional<ProgrammeEntretien> getProgEntretiensById(@PathVariable int id){
		return progEntreRep.findById(id);
	}
	
	@RequestMapping(value="/addProgramme",method=RequestMethod.POST)
	public ProgrammeEntretien addProgramme(@RequestBody ProgrammeEntretien c){
		return progEntreRep.save(c);
	}
	
	@RequestMapping(value="/deleteProgrammeEnt/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable int id){
		progEntreRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editProgramEnt",method=RequestMethod.PUT)
	public ProgrammeEntretien edit(@RequestBody ProgrammeEntretien c){
		 return progEntreRep.save(c);
	}
	
	
//	@RequestMapping(value="/programmeEntretienbyV",method=RequestMethod.GET)
//	public ProgrammeEntretien getProgEntretiensV(){
//		return progEntreRep.findbyVehicule();
//	}
//
//	@RequestMapping(value="/programmeEntretienbyTy",method=RequestMethod.GET)
//	public ProgrammeEntretien getProgEntretiensTE(){
//		return progEntreRep.findbyTypeEntr();
//	}
	
	
	@RequestMapping(value="/entretienByDes/{parametre}",method=RequestMethod.GET)
	public ProgrammeEntretien getEntretienByDes(@PathVariable String parametre){
		return progEntreRep.findByDescription("%"+parametre+"%");
	}
}
