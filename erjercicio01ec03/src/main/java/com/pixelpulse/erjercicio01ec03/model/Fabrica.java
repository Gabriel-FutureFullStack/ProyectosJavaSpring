package com.pixelpulse.erjercicio01ec03.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fabrica")
public class Fabrica implements Serializable {
	
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numFabrica;
	@Column
	private String nombreFabrica;
	@Column
	private String direccion;
	@Column
	private String telefonoContacto;
	
	@OneToMany(mappedBy="fabrica",cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<FabricaArticulo> itemsFabricaArticulo=new HashSet<>();

	public Fabrica() {
		super();
	}
	
	public Fabrica(Fabrica fabrica) {
		this(fabrica.getNumFabrica(), fabrica.getNombreFabrica(), fabrica.getDireccion(), fabrica.getTelefonoContacto());
	}
	
	public Fabrica(Long numFabrica, String nombreFabrica, String direccion, String telefonoContacto) {
		super();
		this.numFabrica = numFabrica;
		this.nombreFabrica = nombreFabrica;
		this.direccion = direccion;
		this.telefonoContacto = telefonoContacto;
	}

	public Long getNumFabrica() {
		return numFabrica;
	}

	public void setNumFabrica(Long numFabrica) {
		this.numFabrica = numFabrica;
	}

	public String getNombreFabrica() {
		return nombreFabrica;
	}

	public void setNombreFabrica(String nombreFabrica) {
		this.nombreFabrica = nombreFabrica;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
