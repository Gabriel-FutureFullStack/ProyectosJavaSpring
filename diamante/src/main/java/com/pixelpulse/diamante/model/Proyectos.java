package com.pixelpulse.diamante.model;

import java.sql.Date;

public class Proyectos {
    private Integer id;
    private String nombre;
    private String ubicacion;
    private String municipalidad;
    private Date fechaAprobacion;
    private Date fechaInicio;
    private Date tiempoEstimado;
    private Date fechaTermino;
    private Double importeInversion;
    private String ingResponsable;
    private String financiera;
    private String descripcion;

    public Proyectos() {
    }
    /*// */
    public Proyectos(Integer id, String nombre, String ubicacion, String municipalidad, Date fechaAprobacion, Date fechaInicio, Date tiempoEstimado, Date fechaTermino, Double importeInversion, String ingResponsable, String financiera, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.municipalidad = municipalidad;
        this.fechaAprobacion = fechaAprobacion;
        this.fechaInicio = fechaInicio;
        this.tiempoEstimado = tiempoEstimado;
        this.fechaTermino = fechaTermino;
        this.importeInversion = importeInversion;
        this.ingResponsable = ingResponsable;
        this.financiera = financiera;
        this.descripcion = descripcion;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getMunicipalidad() {
        return municipalidad;
    }
    public void setMunicipalidad(String municipalidad) {
        this.municipalidad = municipalidad;
    }
    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }
    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getTiempoEstimado() {
        return tiempoEstimado;
    }
    public void setTiempoEstimado(Date tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
    public Date getFechaTermino() {
        return fechaTermino;
    }
    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }
    public Double getImporteInversion() {
        return importeInversion;
    }
    public void setImporteInversion(Double importeInversion) {
        this.importeInversion = importeInversion;
    }
    public String getIngResponsable() {
        return ingResponsable;
    }
    public void setIngResponsable(String ingResponsable) {
        this.ingResponsable = ingResponsable;
    }
    public String getFinanciera() {
        return financiera;
    }
    public void setFinanciera(String financiera) {
        this.financiera = financiera;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
