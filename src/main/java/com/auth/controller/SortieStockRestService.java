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

import com.auth.entitie.SortieStock;
import com.auth.repository.SortieStockRepository;

@RestController
@CrossOrigin(origins="*")
public class SortieStockRestService {
	
	@Autowired
	private SortieStockRepository sortieStockRep ;
	
	@RequestMapping(value="/sortieStocks",method=RequestMethod.GET)
	public List<SortieStock> getSortieStocks(){
		return sortieStockRep.findAll();
	}

	@RequestMapping(value="/sortieStocks/{id}",method=RequestMethod.GET)
	public Optional<SortieStock> getSortieStock(@PathVariable int id){
		return sortieStockRep.findById(id);
	}
	
	@RequestMapping(value="/addSortieSotck",method=RequestMethod.POST)
	public SortieStock addSortieStock(@RequestBody SortieStock c){
		return sortieStockRep.save(c);
	}
	
	@RequestMapping(value="/deleteSortieStock/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable int id){
		sortieStockRep.deleteById(id);
		 return true;
	}
	
	@RequestMapping(value="/editSortieStock",method=RequestMethod.PUT)
	public SortieStock edit(@RequestBody SortieStock c){
		 return sortieStockRep.save(c);
	}
	
//	@RequestMapping(value="/sortiebyV",method=RequestMethod.GET)
//	public SortieStock getSortieStock(){
//		return sortieStockRep.findbyV();
//	}

}
