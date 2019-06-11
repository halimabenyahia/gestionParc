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

import com.auth.entitie.Vehicule;
import com.auth.repository.VehiculeRepository;

@RestController
@CrossOrigin(origins="*")
public class VehiculeRestService {
	
	@Autowired
	private VehiculeRepository vehiculeRep ;
	
	@RequestMapping(value="/vehicules",method=RequestMethod.GET)
	
	public List<Vehicule> getAllVehicule(){
		return vehiculeRep.findAll();
	}

	@RequestMapping(value="/vehiculeById/{id}",method=RequestMethod.GET)
	public Optional<Vehicule> getByIdVehicule(@PathVariable Integer id){
		return vehiculeRep.findById(id);
	}
	
	@RequestMapping(value="/addVehicule",method=RequestMethod.POST)
	public Vehicule addVehicule(@RequestBody Vehicule c){
		return vehiculeRep.save(c);
	}
	
	@RequestMapping(value="/deleteVehicule/{id}",method=RequestMethod.DELETE)
	public boolean deleteVehicule(@PathVariable Integer id){
		vehiculeRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editVehicules",method=RequestMethod.PUT)
	public Vehicule editVehicule(@RequestBody Vehicule c){
		 return vehiculeRep.save(c);
	
	}
	
	@CrossOrigin(origins="*")	
	@RequestMapping(value="/vehiculebyImmatriculation/{chaine}",method=RequestMethod.GET)
	public List<Vehicule> getbyImmatricle(@PathVariable String chaine) {
		System.out.println("in getByMat");
		return vehiculeRep.findByImmatriculation("%"+chaine+"%");
	}
	
	@RequestMapping(value="/vehiculebyImmatriculationV/{chaine}",method=RequestMethod.GET)
	public Vehicule getbyImmatricleV(@PathVariable String chaine) {
		System.out.println("in getByMat");
		return vehiculeRep.findByImmV("%"+chaine+"%");
	}
	
	@RequestMapping(value="/vehiculebyCarburant/{carburant}",method=RequestMethod.GET)
	public List<Vehicule> getVehiculeByCarburant(@PathVariable String carburant) {
		return vehiculeRep.findByCarburant("%"+carburant+"%");
	}
	
	@RequestMapping(value="/vehiculebyAffectation/{affectation}",method=RequestMethod.GET)
	public List<Vehicule> getVehiculeByAffectation(@PathVariable String affectation) {
		return vehiculeRep.findByAffectation("%"+affectation+"%");
	}
	
	@RequestMapping(value="/vehiculebyType/{type}",method=RequestMethod.GET)
	public List<Vehicule> getVehiculeByType(@PathVariable String type) {
		return vehiculeRep.findByTypeVehicule("%"+type+"%");
	}
	
	@RequestMapping(value="/nombreVehicule",method=RequestMethod.GET)
	public int getNombreVehicule() {
		return vehiculeRep.getNombreVehicule();
	}
	
	@RequestMapping(value="/nbPartner",method=RequestMethod.GET)
	public int getNombreVehiculePartner() {
		return vehiculeRep.getNombrePartner();
	}
	
	@RequestMapping(value="/nbCamion",method=RequestMethod.GET)
	public int getNombreVehiculeCamion() {
		return vehiculeRep.getNombreCamion();
	}
	
	@RequestMapping(value="/nbVoiture",method=RequestMethod.GET)
	public int getNombreVehiculeVoiture() {
		return vehiculeRep.getNombreVoiture();
	}
	
	@RequestMapping(value="/nbVoitureEss",method=RequestMethod.GET)
	public int getNombreEss() {
		return vehiculeRep.getNombreEssence();
	}
	
	@RequestMapping(value="/vignetteByImm/{chaine}",method=RequestMethod.GET)
	public List<Vehicule> getVignetteByIMm(@PathVariable String chaine) {
		return vehiculeRep.getVignetteByImm("%"+chaine+"%");
	}
	
}
