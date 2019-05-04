package com.auth.entitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypePiece {
	
	@Id @GeneratedValue
	private int id_typePiece ;
	private String des_typePiece ;
	public int getId_typePiece() {
		return id_typePiece;
	}
	public void setId_typePiece(int id_typePiece) {
		this.id_typePiece = id_typePiece;
	}
	public String getDes_typePiece() {
		return des_typePiece;
	}
	public void setDes_typePiece(String des_typePiece) {
		this.des_typePiece = des_typePiece;
	}
	public TypePiece() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypePiece(int id_typePiece, String des_typePiece) {
		super();
		this.id_typePiece = id_typePiece;
		this.des_typePiece = des_typePiece;
	}

}
