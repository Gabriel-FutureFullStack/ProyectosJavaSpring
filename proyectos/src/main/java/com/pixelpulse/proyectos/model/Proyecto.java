package com.pixelpulse.proyectos.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Proyecto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codP;
	private String nameP;
	@Column(unique = true, nullable = false)
	private String lugarP;
	private String ingenieroP;
	private String codAvObra;
	private Date fechAv;
	private String ingenieroResp;
	private String descAv;
	private String incidencia;
	
	public Proyecto() {
		super();
	}
	
	public Proyecto(Long codP, String nameP, String lugarP, String ingenieroP, String codAvObra, Date fechAv,
			String ingenieroResp, String descAv, String incidencia) {
		super();
		this.codP = codP;
		this.nameP = nameP;
		this.lugarP = lugarP;
		this.ingenieroP = ingenieroP;
		this.codAvObra = codAvObra;
		this.fechAv = fechAv;
		this.ingenieroResp = ingenieroResp;
		this.descAv = descAv;
		this.incidencia = incidencia;
	}

	public Long getCodP() {
		return codP;
	}

	public void setCodP(Long codP) {
		this.codP = codP;
	}

	public String getNameP() {
		return nameP;
	}

	public void setNameP(String nameP) {
		this.nameP = nameP;
	}

	public String getLugarP() {
		return lugarP;
	}

	public void setLugarP(String lugarP) {
		this.lugarP = lugarP;
	}

	public String getIngenieroP() {
		return ingenieroP;
	}

	public void setIngenieroP(String ingenieroP) {
		this.ingenieroP = ingenieroP;
	}

	public String getCodAvObra() {
		return codAvObra;
	}

	public void setCodAvObra(String codAvObra) {
		this.codAvObra = codAvObra;
	}

	public Date getFechAv() {
		return fechAv;
	}

	public void setFechAv(Date fechAv) {
		this.fechAv = fechAv;
	}

	public String getIngenieroResp() {
		return ingenieroResp;
	}

	public void setIngenieroResp(String ingenieroResp) {
		this.ingenieroResp = ingenieroResp;
	}

	public String getDescAv() {
		return descAv;
	}

	public void setDescAv(String descAv) {
		this.descAv = descAv;
	}

	public String getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
