package com.pixelpulse.erjercicio01ec03.model;

import java.io.Serializable;
import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "pedido")

public class Pedido implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numPedido;
	@Column
	private String direccionEnvio;
	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaPedido;
	
	@ManyToOne
	@JoinColumn(name="num_cliente",nullable=false, foreignKey=@ForeignKey
	(foreignKeyDefinition="foreign key(num_cliente) references cliente(num_cliente)"))	
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PedidoArticulo> itemsPedidoArticulo=new HashSet<>();
	
	public Pedido() {		
	}
	
	public Pedido(Pedido pedido)
	{
		this(pedido.getNumPedido(),pedido.getDireccionEnvio(),pedido.getFechaPedido());	
	}
	
	public Pedido(Long numPedido, String direccionEnvio, Date fechaPedido) {
		super();
		this.numPedido = numPedido;
		this.direccionEnvio = direccionEnvio;
		this.fechaPedido = fechaPedido;
	}
	
	@PrePersist
	public void prePersist() {
		fechaPedido=new Date();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<PedidoArticulo> getItemsPedidoArticulo() {
		return itemsPedidoArticulo;
	}

	public void setItemsPedidoArticulo(Set<PedidoArticulo> itemsPedidoArticulo) {
		this.itemsPedidoArticulo = itemsPedidoArticulo;
	}
	
	
	
}
