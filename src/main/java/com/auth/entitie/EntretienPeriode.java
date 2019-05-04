package com.auth.entitie;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EntretienPeriode {
	
	@Id @GeneratedValue
	private int id_entrPeriode ;
	@Temporal(TemporalType.DATE)
	private Date date_p ;
	
	@OneToOne
	@JoinColumn(name="id_programme")
	private ProgrammeEntretien programme_ent_p ;

	public int getId_entrPeriode() {
		return id_entrPeriode;
	}

	public void setId_entrPeriode(int id_entrPeriode) {
		this.id_entrPeriode = id_entrPeriode;
	}

	public Date getDate_p() {
		return date_p;
	}

	public void setDate_p(Date date_p) {
		this.date_p = date_p;
	}

	public ProgrammeEntretien getProgramme_ent_p() {
		return programme_ent_p;
	}

	public void setProgramme_ent_p(ProgrammeEntretien programme_ent_p) {
		this.programme_ent_p = programme_ent_p;
	}

	public EntretienPeriode(int id_entrPeriode, Date date_p, ProgrammeEntretien programme_ent_p) {
		super();
		this.id_entrPeriode = id_entrPeriode;
		this.date_p = date_p;
		this.programme_ent_p = programme_ent_p;
	}

	public EntretienPeriode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
