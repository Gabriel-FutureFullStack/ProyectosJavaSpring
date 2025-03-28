package com.pixelpulse.erjercicio01ec03.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_articulo")
public class PedidoArticulo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="num_pedido",nullable=false, foreignKey=@ForeignKey
	(foreignKeyDefinition="foreign key(num_pedido) references pedido(num_pedido)"))	
	private Pedido pedido;
	@ManyToOne
	@JoinColumn(name="num_articulo",nullable=false, foreignKey=@ForeignKey
	(foreignKeyDefinition="foreign key(num_articulo) references articulo(num_articulo)"))	
    private Articulo articulo;
	@Column
    private int cantidad;

    public PedidoArticulo(Long id, Pedido pedido, Articulo articulo, int cantidad) {
        super();
        this.id = id;
        this.pedido = pedido;
        this.articulo = articulo;
        this.cantidad = cantidad;
    }
    

    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
	
}
