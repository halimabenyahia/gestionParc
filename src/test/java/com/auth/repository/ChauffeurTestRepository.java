package com.auth.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.auth.entitie.Chauffeurs;
import com.test.TestParcRepository;

/*tester persistance chauffeur*/
@SpringBootTest
@Transactional
public class ChauffeurTestRepository extends TestParcRepository {

	
	@Autowired
	ChauffeursRepository chauffeurRep ;

	@Test
	@Override
	public void givenEntityRepository_whenSaving() {
		System.out.println("--------------- Testing givenEntityRepository_whenSaving Method ---------------");
		Chauffeurs savedchauffeur=new Chauffeurs() ;
		savedchauffeur.setNom_ch("ben ali");
		savedchauffeur=chauffeurRep.save(savedchauffeur);
		System.out.println("--------------- chauffeur saved ---------------");
		Chauffeurs foundChauffeur = chauffeurRep.findBynomChauffeur(savedchauffeur.getNom_ch());
		assertNotNull(foundChauffeur);
		System.out.println("--------------- chauffeur trouvé ---------------");
		assertEquals( foundChauffeur.getId_chauffeur(), savedchauffeur.getId_chauffeur());	

	}

	@Test
	@Override
	public void givenEntityRepository_whenUpdating() {
		System.out.println("--------------- Testing givenEntityRepository_whenUpdating Method ---------------");
		Chauffeurs savedchauffeur=new Chauffeurs() ;
		savedchauffeur.setNom_ch("ben ali");
		savedchauffeur = chauffeurRep.save(savedchauffeur);
		savedchauffeur.setNom_ch("ali");
		savedchauffeur = chauffeurRep.save(savedchauffeur);
		Chauffeurs foundChauffeurs = chauffeurRep.getOne(savedchauffeur.getId_chauffeur());
		assertEquals(foundChauffeurs.getNom_ch(), savedchauffeur.getNom_ch());
		
	}
	

	@Test
	@Override
	public void givenEntityRepository_whenDeleting() {
		Chauffeurs savedChauffeurs = new Chauffeurs() ;
		savedChauffeurs.setNom_ch("ben yahia");
		savedChauffeurs = chauffeurRep.save(savedChauffeurs);
		chauffeurRep.delete(savedChauffeurs);
		Chauffeurs foundChauffeurs = chauffeurRep.findBynomChauffeur(savedChauffeurs.getNom_ch());
		assertEquals(null, foundChauffeurs);

		
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingAll() {
		Chauffeurs savedChauffeurs = new Chauffeurs() ;
		savedChauffeurs.setNom_ch("ben yahia");
		savedChauffeurs = chauffeurRep.save(savedChauffeurs);
		List<Chauffeurs> list = chauffeurRep.findAll();
		assertEquals(1, list.size());
	}

	@Test
	@Override
	public void givenEntityRepository_whenRetrievingOneById() {
		Chauffeurs savedChauffeurs = new Chauffeurs();
		savedChauffeurs.setNom_ch("ben yahia");
		savedChauffeurs = chauffeurRep.save(savedChauffeurs);
		savedChauffeurs.setNom_ch("ben yahia");
		Chauffeurs foundChauffeurs = chauffeurRep.getOne(savedChauffeurs.getId_chauffeur());
		assertEquals(foundChauffeurs.getId_chauffeur(), savedChauffeurs.getId_chauffeur());
		
	}
}
