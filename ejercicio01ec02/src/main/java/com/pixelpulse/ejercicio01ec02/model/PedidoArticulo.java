package com.pixelpulse.ejercicio01ec02.model;

public class PedidoArticulo{
    private static final long serialVersionUID = 1L;
    private Pedido pedido;
    private Articulo articulo;
    private Integer cantidad;
    
    public PedidoArticulo() {
        super();
    }

    public PedidoArticulo(Pedido pedido, Articulo articulo, Integer cantidad) {
        this.pedido = pedido;
        this.articulo = articulo;
        this.cantidad = cantidad;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
