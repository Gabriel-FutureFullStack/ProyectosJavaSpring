package com.pixelpulse.ejercicio01ec02.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numCliente;
	@Column
	private String nombreCliente;
	@Column
	private String direccion1;
	@Column
	private String direccion2;
	@Column
	private String direccion3;
	@Column
	private Double saldo;
	@Column
	private Double limiteSaldo;
	@Column
	private Double descuento;
	
	//@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL, orphanRemoval=true)
	@OneToMany(mappedBy="cliente")
    private Collection<Pedido> itemsPedido= new ArrayList<>();
	
	public Cliente() {
		super();
	}

	public Cliente(Long numCliente, String nombreCliente, String direccion1, String direccion2, String direccion3,
			Double saldo, Double limiteSaldo, Double descuento, Collection<Pedido> itemsPedido) {
		this.numCliente = numCliente;
		this.nombreCliente = nombreCliente;
		this.direccion1 = direccion1;
		this.direccion2 = direccion2;
		this.direccion3 = direccion3;
		this.saldo = saldo;
		this.limiteSaldo = limiteSaldo;
		this.descuento = descuento;
		this.itemsPedido = itemsPedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(Long numCliente) {
		this.numCliente = numCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDireccion1() {
		return direccion1;
	}

	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}

	public String getDireccion2() {
		return direccion2;
	}

	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}

	public String getDireccion3() {
		return direccion3;
	}

	public void setDireccion3(String direccion3) {
		this.direccion3 = direccion3;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimiteSaldo() {
		return limiteSaldo;
	}

	public void setLimiteSaldo(Double limiteSaldo) {
		this.limiteSaldo = limiteSaldo;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Collection<Pedido> getItemsPedido() {
		return itemsPedido;
	}

	public void setItemsPedido(Collection<Pedido> itemsPedido) {
		this.itemsPedido = itemsPedido;
	}
	
}
