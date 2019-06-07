package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.Vehicule;
import com.test.TestParcRepository;

@SpringBootTest
@Transactional
public class VehiculeTestRepository extends TestParcRepository {
	
	@Autowired
	VehiculeRepository vehiculeRep ;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		Vehicule savedVehicule=new Vehicule() ;
		savedVehicule.setImmatriculation("200tu2000");
		savedVehicule=vehiculeRep.save(savedVehicule);
		Vehicule foundVehicule = vehiculeRep.findByImmV(savedVehicule.getImmatriculation());
		assertNotNull(foundVehicule);
		assertEquals( foundVehicule.getId_vehicule(), savedVehicule.getId_vehicule());	
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		Vehicule savedVehicule=new Vehicule() ;
		savedVehicule.setImmatriculation("200tu2000");
		savedVehicule=vehiculeRep.save(savedVehicule);
		savedVehicule.setImmatriculation("200tu3000");
		savedVehicule = vehiculeRep.save(savedVehicule);
		Vehicule foundVehicule = vehiculeRep.getOne(savedVehicule.getId_vehicule());
		assertEquals(foundVehicule.getImmatriculation(), savedVehicule.getImmatriculation());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		Vehicule savedVehicule=new Vehicule() ;
		savedVehicule.setImmatriculation("200tu2000");
		savedVehicule=vehiculeRep.save(savedVehicule);
		vehiculeRep.delete(savedVehicule);
		Vehicule foundVehicule = vehiculeRep.findByImmV(savedVehicule.getImmatriculation());
		assertEquals(null, foundVehicule);
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		Vehicule savedVehicule=new Vehicule() ;
		savedVehicule.setImmatriculation("200tu2000");
		savedVehicule=vehiculeRep.save(savedVehicule);
		List<Vehicule> list = vehiculeRep.findAll();
		assertEquals(1, list.size());
		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		Vehicule savedVehicule = new Vehicule();
		savedVehicule.setImmatriculation("200tu2000");
		savedVehicule=vehiculeRep.save(savedVehicule);
		savedVehicule.setImmatriculation("200tu2001");
		Vehicule foundVehicule = vehiculeRep.getOne(savedVehicule.getId_vehicule());
		assertEquals(foundVehicule.getId_vehicule(), savedVehicule.getId_vehicule());
		
	}

}
