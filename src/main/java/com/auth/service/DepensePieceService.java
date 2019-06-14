package com.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.Depense;
import com.auth.entitie.Depense_Piece;
import com.auth.repository.DepenseRepository;
import com.auth.repository.Depense_PieceRepository;
import com.auth.repository.PieceRepository;

@Service
public class DepensePieceService {
	
	
	@Autowired
	DepenseRepository depenseRep ;
	
	@Autowired
	Depense_PieceRepository depensePieceRep ;
	
//	public List<Depense> getListDepense() {
//		List<Depense> result = depenseRep.getDepenseMaster();
//		return result ;
//	}
//	
//	public  List<Depense_Piece> getListDepPi(){
//		List<Depense_Piece> result1= depensePieceRep.getListDepPiece();
//		return result1 ;
//	}
	
	public List<Depense_Piece> getResult(){
		
		List<Depense> d1 = depenseRep.findAll();
		List<Depense_Piece> d2 = depensePieceRep.findAll();
		
		
		for (int i = 0; i < d1.size(); i++) {
			for (int j = 0 ; j<d2.size() ; j++) {
			System.out.println("{");
			System.out.println("--immatricule" + d1.get(i).getVehicule_dep().getImmatriculation());
			System.out.println("--date de dépense" +d1.get(i).getDate_depense());
			System.out.println("--type de dépense " + d1.get(i).getTypedepense().getDesignation_typeDep());
			
			
	           
			System.out.println("------>piece  " + d2.get(j).getPiece_dep());
			System.out.println("------>qte  " + d2.get(j).getQte());
			System.out.println("------>hors taxe  " + d2.get(j).getHors_taxe());
			System.out.println("------>ttc  " + d2.get(j).getTtc_dp());
			System.out.println("}");		 
		   
		}  
	}
		return d2; 
	}
	
	@Transactional
	public List<Depense_Piece> add(Depense d , List<Depense_Piece> dp){
		//Depense d = new Depense() ;
		List<Depense> d1 = depenseRep.findAll();
		List<Depense_Piece> d2 =depensePieceRep.findAll();
		
		for (int i = 0; i < d1.size(); i++) {
			depenseRep.save(d);
			
			for (int j=0 ; j< d2.size() ; j++) {
				int r =d2.get(j).getPiece_dep().getId_piece();
				if (r != 0) {
					depensePieceRep.saveAll(dp);
				}
			}
		}
		return d2 ;
	}

}
