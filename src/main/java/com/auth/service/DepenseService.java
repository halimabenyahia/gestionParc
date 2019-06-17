package com.auth.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.auth.entitie.Depense;
import com.auth.entitie.DepenseResponse;
import com.auth.entitie.Vehicule;
import com.auth.repository.DepenseRepository;
import com.auth.repository.Depense_PieceRepository;
import com.auth.repository.VehiculeRepository;

@Service
public class DepenseService {

	@Autowired
	private VehiculeRepository vehiculeRep;

	@Autowired
	private DepenseRepository depenseRep;
	
	@Autowired
	private Depense_PieceRepository depensePieceRep ;

//	public Long getSumMonth(String matricule, int mois) {
//		Long jan = new Long(0);
//		try {
//			jan = depenseRep.getAllMonths(matricule, mois);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return jan;
//	}
//	
//	
//	public Long getResultByType(String matricule , int mois ) {
//		Long result = new Long(0);
//		try {
//			 result = depenseRep.getAllMonthByType(matricule, mois );
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return result ;
//	}
//
//	public List<DepenseResponse> listeDepenses() {
//		LinkedList<DepenseResponse> l = new LinkedList<DepenseResponse>();
//		LinkedList<Vehicule> l2 = new LinkedList<Vehicule>();
//		List<Vehicule> v = vehiculeRep.findAll();
//
//		for (int i = 0; i < v.size(); i++) {
//			DepenseResponse d = new DepenseResponse();
//			d.setImmatriculation(v.get(i).getImmatriculation());
//			d.setDep_janvier(getSumMonth(v.get(i).getImmatriculation(), 01));
//			d.setDep_fevrier(getSumMonth(v.get(i).getImmatriculation(), 02));
//			d.setDep_mars(getSumMonth(v.get(i).getImmatriculation(), 03));
//			d.setDep_avril(getSumMonth(v.get(i).getImmatriculation(), 04));
//			d.setDep_mai(getSumMonth(v.get(i).getImmatriculation(), 05));
//			d.setDep_juin(getSumMonth(v.get(i).getImmatriculation(), 06));
//			d.setDep_juillet(getSumMonth(v.get(i).getImmatriculation(), 07));
//			d.setDep_aout(getSumMonth(v.get(i).getImmatriculation(), 8));
//			d.setDep_septembre(getSumMonth(v.get(i).getImmatriculation(), 9));
//			d.setDep_octobre(getSumMonth(v.get(i).getImmatriculation(), 10));
//			d.setDep_novembre(getSumMonth(v.get(i).getImmatriculation(), 11));
//			d.setDep_decembre(getSumMonth(v.get(i).getImmatriculation(), 12));
//			l.add(d);
//		}
//
//		for (int i = 0; i < l.size(); i++) {
//			System.out.println("--->" + l.get(i).getImmatriculation());
//			System.out.println("--->" + l.get(i).getDep_janvier());
//			System.out.println("--->" + l.get(i).getDep_fevrier());
//			System.out.println("--->" + l.get(i).getDep_mars());
//			System.out.println("--->" + l.get(i).getDep_avril());
//		}
//
//		for (int j = 0; j < l2.size(); j++) {
//			DepenseResponse d3 = new DepenseResponse();
//			d3.setImmatriculation(l2.get(j).getImmatriculation());
//		}
//		return l;
//	}
//
//	public List<DepenseResponse> oneDepense(String matricule) {
//		LinkedList<DepenseResponse> l = new LinkedList<DepenseResponse>();
//		Vehicule v = vehiculeRep.findByImmV(matricule);
//		
//		DepenseResponse d = new DepenseResponse();
//		d.setImmatriculation(v.getImmatriculation());
//		d.setDep_janvier(getResultByType(v.getImmatriculation(), 01));
//		d.setDep_fevrier(getResultByType(v.getImmatriculation(), 02 ));
//		d.setDep_mars(getResultByType(v.getImmatriculation(), 03));
//		d.setDep_avril(getResultByType(v.getImmatriculation(), 04));
//		d.setDep_mai(getResultByType(v.getImmatriculation(), 05));
//		d.setDep_juin(getResultByType(v.getImmatriculation(), 06));
//		d.setDep_juillet(getResultByType(v.getImmatriculation(), 07));
//		d.setDep_aout(getResultByType(v.getImmatriculation(), 8));
//		d.setDep_septembre(getResultByType(v.getImmatriculation(), 9));
//		d.setDep_octobre(getResultByType(v.getImmatriculation(), 10));
//		d.setDep_novembre(getResultByType(v.getImmatriculation(), 11));
//		d.setDep_decembre(getResultByType(v.getImmatriculation(), 12));
//
//		l.add(d);
//		return l;
//	}
	
/* depense carburant*/	
	public Long getSumMonthss(String matricule , int mois) {
	Long jan = new Long(0);
	try {
		jan = depenseRep.getMonthCarburant(matricule,mois);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return jan;
}
	
	
	public List<DepenseResponse> listeDepensesByCarburant() {
	LinkedList<DepenseResponse> l = new LinkedList<DepenseResponse>();
	LinkedList<Vehicule> l2 = new LinkedList<Vehicule>();
	List<Vehicule> v = vehiculeRep.findAll();

	for (int i = 0; i < v.size(); i++) {
		DepenseResponse d = new DepenseResponse();
		d.setImmatriculation(v.get(i).getImmatriculation());
		d.setDep_janvier(getSumMonthss(v.get(i).getImmatriculation(), 01));
		d.setDep_fevrier(getSumMonthss(v.get(i).getImmatriculation(), 02));
		d.setDep_mars(getSumMonthss(v.get(i).getImmatriculation(), 03));
		d.setDep_avril(getSumMonthss(v.get(i).getImmatriculation(), 04));
		d.setDep_mai(getSumMonthss(v.get(i).getImmatriculation(), 05));
		d.setDep_juin(getSumMonthss(v.get(i).getImmatriculation(), 06));
		d.setDep_juillet(getSumMonthss(v.get(i).getImmatriculation(), 07));
		d.setDep_aout(getSumMonthss(v.get(i).getImmatriculation(), 8));
		d.setDep_septembre(getSumMonthss(v.get(i).getImmatriculation(), 9));
		d.setDep_octobre(getSumMonthss(v.get(i).getImmatriculation(), 10));
		d.setDep_novembre(getSumMonthss(v.get(i).getImmatriculation(), 11));
		d.setDep_decembre(getSumMonthss(v.get(i).getImmatriculation(), 12));
		l.add(d);
	}

	for (int i = 0; i < l.size(); i++) {
		System.out.println("--->" + l.get(i).getImmatriculation());
		System.out.println("--->" + l.get(i).getDep_janvier());
		System.out.println("--->" + l.get(i).getDep_fevrier());
		System.out.println("--->" + l.get(i).getDep_mars());
		System.out.println("--->" + l.get(i).getDep_avril());
	}

	for (int j = 0; j < l2.size(); j++) {
		DepenseResponse d3 = new DepenseResponse();
		d3.setImmatriculation(l2.get(j).getImmatriculation());
	}
	return l;
}
	/*****/
	
	
	/*depense piece */
	
	public Long getSumMonthP(String matricule , int mois) {
		Long jan = new Long(0);
		try {
			jan = depensePieceRep.getMonthPiece(matricule,mois);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return jan;
	}
	public List<DepenseResponse> listeDepensesByPiece() {
		LinkedList<DepenseResponse> l = new LinkedList<DepenseResponse>();
		LinkedList<Vehicule> l2 = new LinkedList<Vehicule>();
		List<Vehicule> v = vehiculeRep.findAll();

		for (int i = 0; i < v.size(); i++) {
			DepenseResponse d = new DepenseResponse();
			d.setImmatriculation(v.get(i).getImmatriculation());
			d.setDep_janvier(getSumMonthP(v.get(i).getImmatriculation(), 01));
			d.setDep_fevrier(getSumMonthP(v.get(i).getImmatriculation(), 02));
			d.setDep_mars(getSumMonthP(v.get(i).getImmatriculation(), 03));
			d.setDep_avril(getSumMonthP(v.get(i).getImmatriculation(), 04));
			d.setDep_mai(getSumMonthP(v.get(i).getImmatriculation(), 05));
			d.setDep_juin(getSumMonthP(v.get(i).getImmatriculation(), 06));
			d.setDep_juillet(getSumMonthP(v.get(i).getImmatriculation(), 07));
			d.setDep_aout(getSumMonthP(v.get(i).getImmatriculation(), 8));
			d.setDep_septembre(getSumMonthP(v.get(i).getImmatriculation(), 9));
			d.setDep_octobre(getSumMonthP(v.get(i).getImmatriculation(), 10));
			d.setDep_novembre(getSumMonthP(v.get(i).getImmatriculation(), 11));
			d.setDep_decembre(getSumMonthP(v.get(i).getImmatriculation(), 12));
			l.add(d);
		}

		for (int i = 0; i < l.size(); i++) {
			System.out.println("--->" + l.get(i).getImmatriculation());
			System.out.println("--->" + l.get(i).getDep_janvier());
			System.out.println("--->" + l.get(i).getDep_fevrier());
			System.out.println("--->" + l.get(i).getDep_mars());
			System.out.println("--->" + l.get(i).getDep_avril());
		}

		for (int j = 0; j < l2.size(); j++) {
			DepenseResponse d3 = new DepenseResponse();
			d3.setImmatriculation(l2.get(j).getImmatriculation());
		}
		return l;
	}
	
	
	public Long getResultByTypeCarburant(String matricule , int mois ) {
	Long result = new Long(0);
	try {
		 result = depenseRep.getAllMonthByType(matricule, mois );
	} catch (Exception e) {
		// TODO: handle exception
	}
	return result ;
}
	
	
	public List<DepenseResponse> oneDepenseCarburant(String matricule) {
	LinkedList<DepenseResponse> l = new LinkedList<DepenseResponse>();
	Vehicule v = vehiculeRep.findByImmV(matricule);
	
	DepenseResponse d = new DepenseResponse();
	d.setImmatriculation(v.getImmatriculation());
	d.setDep_janvier(getResultByTypeCarburant(v.getImmatriculation(), 01));
	d.setDep_fevrier(getResultByTypeCarburant(v.getImmatriculation(), 02 ));
	d.setDep_mars(getResultByTypeCarburant(v.getImmatriculation(), 03));
	d.setDep_avril(getResultByTypeCarburant(v.getImmatriculation(), 04));
	d.setDep_mai(getResultByTypeCarburant(v.getImmatriculation(), 05));
	d.setDep_juin(getResultByTypeCarburant(v.getImmatriculation(), 06));
	d.setDep_juillet(getResultByTypeCarburant(v.getImmatriculation(), 07));
	d.setDep_aout(getResultByTypeCarburant(v.getImmatriculation(), 8));
	d.setDep_septembre(getResultByTypeCarburant(v.getImmatriculation(), 9));
	d.setDep_octobre(getResultByTypeCarburant(v.getImmatriculation(), 10));
	d.setDep_novembre(getResultByTypeCarburant(v.getImmatriculation(), 11));
	d.setDep_decembre(getResultByTypeCarburant(v.getImmatriculation(), 12));

	l.add(d);
	return l;
}
	
	
	
	
	

}
