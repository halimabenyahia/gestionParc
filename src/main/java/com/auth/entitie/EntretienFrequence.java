package com.auth.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class EntretienFrequence {
	
	@Id @GeneratedValue
	private int id_entretienFreq ;
	private Long kilometrage ;
	
	
	@OneToOne
	@JoinColumn(name="id_programme")
	private ProgrammeEntretien programme_ent_freq ;


	public int getId_entretienFreq() {
		return id_entretienFreq;
	}


	public void setId_entretienFreq(int id_entretienFreq) {
		this.id_entretienFreq = id_entretienFreq;
	}


	public Long getKilometrage() {
		return kilometrage;
	}


	public void setKilometrage(Long kilometrage) {
		this.kilometrage = kilometrage;
	}

	public ProgrammeEntretien getProgramme_ent_freq() {
		return programme_ent_freq;
	}


	public void setProgramme_ent_freq(ProgrammeEntretien programme_ent_freq) {
		this.programme_ent_freq = programme_ent_freq;
	}


	public EntretienFrequence(int id_entretienFreq, Long kilometrage, ProgrammeEntretien programme_ent_freq) {
		super();
		this.id_entretienFreq = id_entretienFreq;
		this.kilometrage = kilometrage;
		this.programme_ent_freq = programme_ent_freq;
	}


	public EntretienFrequence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
