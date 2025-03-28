package com.pixelpulse.erjercicio01ec03.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "fabrica_articulo")
public class FabricaArticulo implements Serializable {
	
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="num_articulo",nullable=false, foreignKey=@ForeignKey
	(foreignKeyDefinition="foreign key(num_articulo) references articulo(num_articulo)"))	
	private Articulo articulo;
	@ManyToOne
	@JoinColumn(name="num_fabrica",nullable=false, foreignKey=@ForeignKey
	(foreignKeyDefinition="foreign key(num_fabrica) references fabrica(num_fabrica)"))
	private Fabrica fabrica;
	@Column
	private Integer existencias;
	
	public FabricaArticulo(Long id, Articulo articulo, Fabrica fabrica, Integer existencias) {
		super();
		this.id = id;
		this.articulo = articulo;
		this.fabrica = fabrica;
		this.existencias = existencias;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Fabrica getFabrica() {
		return fabrica;
	}

	public void setFabrica(Fabrica fabrica) {
		this.fabrica = fabrica;
	}

	public Integer getExistencias() {
		return existencias;
	}

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
