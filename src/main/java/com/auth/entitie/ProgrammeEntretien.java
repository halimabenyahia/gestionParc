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
public class ProgrammeEntretien {
	
	@Id @GeneratedValue
	private int id_programme ;
	@Temporal(TemporalType.DATE)
	private Date date_prev_ent ;
	private Long compteur_e ;
	private Boolean execution ;
	@Temporal(TemporalType.DATE)
	private Date date_execution ;
	

//	
	@OneToOne
	@JoinColumn(name="id_typeEntretien")
	private TypeEntretien type_entretien ;

	public int getId_programme() {
		return id_programme;
	}

	public void setId_programme(int id_programme) {
		this.id_programme = id_programme;
	}

	public Date getDate_prev_ent() {
		return date_prev_ent;
	}

	public void setDate_prev_ent(Date date_prev_ent) {
		this.date_prev_ent = date_prev_ent;
	}

	public Long getCompteur_e() {
		return compteur_e;
	}

	public void setCompteur_e(Long compteur_e) {
		this.compteur_e = compteur_e;
	}

	public Boolean getExecution() {
		return execution;
	}

	public void setExecution(Boolean execution) {
		this.execution = execution;
	}

	public Date getDate_execution() {
		return date_execution;
	}

	public void setDate_execution(Date date_execution) {
		this.date_execution = date_execution;
	}


	public TypeEntretien getType_entretien() {
		return type_entretien;
	}

	public void setType_entretien(TypeEntretien type_entretien) {
		this.type_entretien = type_entretien;
	}

	public ProgrammeEntretien(int id_programme, Date date_prev_ent, Long compteur_e, Boolean execution,
			Date date_execution, TypeEntretien type_entretien) {
		super();
		this.id_programme = id_programme;
		this.date_prev_ent = date_prev_ent;
		this.compteur_e = compteur_e;
		this.execution = execution;
		this.date_execution = date_execution;
		this.type_entretien = type_entretien;
	}

	public ProgrammeEntretien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
