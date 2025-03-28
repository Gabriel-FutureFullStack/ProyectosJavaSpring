package com.pixelpulse.pregunta01ec03.model;

public class RolCliente {
    private Cliente cliente;
    private Rol rol;
    public RolCliente() {
        super();
    }
    public RolCliente(Cliente cliente, Rol rol) {
        this.cliente = cliente;
        this.rol = rol;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
