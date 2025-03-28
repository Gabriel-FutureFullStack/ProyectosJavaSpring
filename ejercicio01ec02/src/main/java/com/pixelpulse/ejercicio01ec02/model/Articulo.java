package com.pixelpulse.ejercicio01ec02.model;

import java.io.Serializable;
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
import jakarta.persistence.Table;

@Entity
@Table(name = "articulo")
public class Articulo implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numArticulo;
    @Column
    private String descripcion;

    @ManyToMany(mappedBy="itemsArticulo",cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Pedido> itemsPedido=new HashSet<>();

    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="fabrica_articulo",
	           joinColumns=@JoinColumn(name="num_articulo",nullable=false,
	           foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(num_articulo) references articulo(num_articulo)")),
	           inverseJoinColumns=@JoinColumn(name="num_fabrica",nullable=false,
	           foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(num_fabrica) references fabrica(num_fabrica)")))
	private Set<Fabrica> itemsFabrica=new HashSet<>();

    public Articulo() {
        super();
    }

    public Articulo(Long numArticulo, String descripcion, Set<Pedido> itemsPedido) {
        this.numArticulo = numArticulo;
        this.descripcion = descripcion;
        this.itemsPedido = itemsPedido;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public Set<Pedido> getItemsPedido() {
        return itemsPedido;
    }

    public void setItemsPedido(Set<Pedido> itemsPedido) {
        this.itemsPedido = itemsPedido;
    }
}