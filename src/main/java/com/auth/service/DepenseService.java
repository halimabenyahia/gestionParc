package com.auth.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.auth.entitie.Depense;
import com.auth.entitie.DepenseResponse;
import com.auth.entitie.Vehicule;
import com.auth.repository.DepenseRepository;
import com.auth.repository.VehiculeRepository;

@Service
public class DepenseService {
	
	@Autowired
	private VehiculeRepository vehiculeRep ;
	
	@Autowired
	private DepenseRepository depenseRep ;
	
	
	public Long getSumJanvier (String matricule,int mois) {
		Long jan=new Long(0);
		try {
			 jan=depenseRep.getJanvier(matricule,mois);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jan ;
	}
	
	
	
	
	
	
	public  List<DepenseResponse> listeDepenses()
	{
		System.out.println("--------->");
		System.out.println("vehicule");
		LinkedList<DepenseResponse>	 l=new LinkedList<DepenseResponse>();
		LinkedList<Vehicule> l2= new LinkedList<Vehicule>();
		//l2=vehiculeRep.findAll();
		
		List<Vehicule> v=vehiculeRep.findAll();
		
		for(int i=0;i<v.size();i++)
		{
			
			
		DepenseResponse d=new DepenseResponse();
		d.setImmatriculation(v.get(i).getImmatriculation());
		d.setDep_janvier(getSumJanvier(v.get(i).getImmatriculation(),01));
		d.setDep_fevrier(getSumJanvier(v.get(i).getImmatriculation(),02));
		d.setDep_mars(getSumJanvier(v.get(i).getImmatriculation(),03));
		d.setDep_avril(getSumJanvier(v.get(i).getImmatriculation(),04));
		d.setDep_mai(getSumJanvier(v.get(i).getImmatriculation(),05));
		d.setDep_juin(getSumJanvier(v.get(i).getImmatriculation(),06));
		d.setDep_juillet(getSumJanvier(v.get(i).getImmatriculation(),07));
		d.setDep_aout(getSumJanvier(v.get(i).getImmatriculation(),8));
		d.setDep_septembre(getSumJanvier(v.get(i).getImmatriculation(),9));
		d.setDep_octobre(getSumJanvier(v.get(i).getImmatriculation(),10));
		d.setDep_novembre(getSumJanvier(v.get(i).getImmatriculation(),11));
		d.setDep_decembre(getSumJanvier(v.get(i).getImmatriculation(),12));
		l.add(d);
		
		
		}
		
		
		for(int i=0;i<l.size();i++)
		{System.out.println("--->"+l.get(i).getImmatriculation());
		System.out.println("--->"+l.get(i).getDep_janvier());
		System.out.println("--->"+l.get(i).getDep_fevrier());
		System.out.println("--->"+l.get(i).getDep_mars());
		System.out.println("--->"+l.get(i).getDep_avril());
		
		}
		
		for(int j=0;j<l2.size();j++) {
			DepenseResponse d3=new DepenseResponse();
			d3.setImmatriculation(l2.get(j).getImmatriculation());
			//d3.setDep_janvier();
				
		}
		
		
		return l;
	}
	
	
	
	
	
	
	}


