package com.pixelpulse.ejercicio02ec02.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicamento")
public class Medicamento {
    @Id
    @Column(name="codigo_medicamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoM;
    @Column(name="nombre_medicamento")
    private String nombreM;
    @Column(name="laboratorio_origen")
    private String labOrigin;
    @Column(name="precio_venta")
    private Double precioV;
    @Column()
    private Integer stock;

    public Medicamento() {
        super();
    }

    public Medicamento(Long codigoM, String nombreM, String labOrigin, Double precioV, Integer stock) {
        this.codigoM = codigoM;
        this.nombreM = nombreM;
        this.labOrigin = labOrigin;
        this.precioV = precioV;
        this.stock = stock;
    }

    public Long getCodigoM() {
        return codigoM;
    }

    public void setCodigoM(Long codigoM) {
        this.codigoM = codigoM;
    }

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public String getLabOrigin() {
        return labOrigin;
    }

    public void setLabOrigin(String labOrigin) {
        this.labOrigin = labOrigin;
    }

    public Double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(Double precioV) {
        this.precioV = precioV;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    
}
