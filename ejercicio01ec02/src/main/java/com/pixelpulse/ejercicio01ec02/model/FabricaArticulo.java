package com.pixelpulse.ejercicio01ec02.model;

public class FabricaArticulo {
    private Articulo articulo;
    private Fabrica fabrica;
    private Integer existencias;
    public FabricaArticulo() {
        super();
    }
    public FabricaArticulo(Articulo articulo, Fabrica fabrica, Integer existencias) {
        this.articulo = articulo;
        this.fabrica = fabrica;
        this.existencias = existencias;
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
    
}
