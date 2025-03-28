package com.pixelpulse.ejercicio01ec02.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numPedido;
	@Column
	private String direccionEnvio;
	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaPedido;
	@ManyToOne
	@JoinColumn(name = "num_cliente", nullable = false, foreignKey = @ForeignKey (name = "fk_pedido_cliente"))
	private Cliente cliente;

	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="pedido_articulo",
	           joinColumns=@JoinColumn(name="num_pedido",nullable=false,
	           foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(num_pedido) references pedido(num_pedido)")),
	           inverseJoinColumns=@JoinColumn(name="num_articulo",nullable=false,
	           foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(num_articulo) references articulo(num_articulo)")))
	private Set<Articulo> itemsArticulo=new HashSet<>();

	public Pedido() {
		super();
	}

	public Pedido(Long numPedido, String direccionEnvio, Date fechaPedido, Cliente cliente,
			Set<Articulo> itemsArticulo) {
		this.numPedido = numPedido;
		this.direccionEnvio = direccionEnvio;
		this.fechaPedido = fechaPedido;
		this.cliente = cliente;
		this.itemsArticulo = itemsArticulo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getNumPedido() {
		return numPedido;
	}

	public void setNumPedido(Long numPedido) {
		this.numPedido = numPedido;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Articulo> getItemsArticulo() {
		return itemsArticulo;
	}

	public void setItemsArticulo(Set<Articulo> itemsArticulo) {
		this.itemsArticulo = itemsArticulo;
	}
	
}