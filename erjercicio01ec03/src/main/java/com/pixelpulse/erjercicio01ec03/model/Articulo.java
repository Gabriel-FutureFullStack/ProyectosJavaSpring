package com.pixelpulse.erjercicio01ec03.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numArticulo;
	@Column
	private String descripcion;
	@OneToMany(mappedBy="articulo",cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<PedidoArticulo> itemsPedidoArticulo=new HashSet<>();
	
	@OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<FabricaArticulo> itemsFabrica =new HashSet<>();
	
	public Articulo() {
		super();
	}
	public Articulo(Articulo articulo) {
		this(articulo.getNumArticulo(), articulo.getDescripcion());
	}
	public Articulo(Long numArticulo, String descripcion) {
		super();
		this.numArticulo = numArticulo;
		this.descripcion = descripcion;
	}
	public Long getNumArticulo() {
		return numArticulo;
	}
	public void setNumArticulo(Long numArticulo) {
		this.numArticulo = numArticulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
