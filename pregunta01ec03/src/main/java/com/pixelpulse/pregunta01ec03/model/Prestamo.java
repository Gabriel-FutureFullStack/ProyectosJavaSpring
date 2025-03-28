package com.pixelpulse.pregunta01ec03.model;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "prestamo")
public class Prestamo implements Serializable{
    //Atributos del Prestamo
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPrestamo;
    @Column
    private Date fechaPrestamo;
    @Column
    private Double importePrestado;
    @Column
    private Integer numCuotas;
    @Column
    private Double interes;

    @ManyToOne
    @JoinColumn(name = "dni_cliente", nullable = false, foreignKey = @ForeignKey(name = "fk_prestamo_cliente"))
    private Cliente cliente;

    public Prestamo() {
        super();
    }

    public Prestamo(Long numPrestamo, Date fechaPrestamo, Double importePrestado, Integer numCuotas,
            Double interes, Cliente cliente) {
        this.numPrestamo = numPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.importePrestado = importePrestado;
        this.numCuotas = numCuotas;
        this.interes = interes;
        this.cliente = cliente;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getNumPrestamo() {
        return numPrestamo;
    }

    public void setNumPrestamo(Long numPrestamo) {
        this.numPrestamo = numPrestamo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Double getImportePrestado() {
        return importePrestado;
    }

    public void setImportePrestado(Double importePrestado) {
        this.importePrestado = importePrestado;
    }

    public Integer getNumCuotas() {
        return numCuotas;
    }

    public void setNumCuotas(Integer numCuotas) {
        this.numCuotas = numCuotas;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
