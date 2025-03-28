package com.pixelpulse.entidadfinanciera.model;

import java.io.Serializable;
import java.sql.Date;

public class Prestamo implements Serializable{
    private static final long serailVersionUID = 1L;
    private Integer id;
    private Date fecha;
    private String nameFinancista;
    private String nameCliente;
    private Double importePrestado;
    private Double numeroLetras;
    private Double interes;

    public Prestamo(){
    }
    public Prestamo(Integer id, Date fecha, String nameFinancista, String nameCliente, Double importePrestado, Double numeroLetras, Double interes) {
        this.id = id;
        this.fecha = fecha;
        this.nameFinancista = nameFinancista;
        this.nameCliente = nameCliente;
        this.importePrestado = importePrestado;
        this.numeroLetras = numeroLetras;
        this.interes = interes;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getNameFinancista() {
        return nameFinancista;
    }
    public void setNameFinancista(String nameFinancista) {
        this.nameFinancista = nameFinancista;
    }
    public String getNameCliente() {
        return nameCliente;
    }
    public void setNameCliente(String nameCliente) {
        this.nameCliente = nameCliente;
    }
    public Double getImportePrestado() {
        return importePrestado;
    }
    public void setImportePrestado(Double importePrestado) {
        this.importePrestado = importePrestado;
    }
    public Double getNumeroLetras() {
        return numeroLetras;
    }
    public void setNumeroLetras(Double numeroLetras) {
        this.numeroLetras = numeroLetras;
    }
    public Double getInteres() {
        return interes;
    }
    public void setInteres(Double interes) {
        this.interes = interes;
    }
    public static long getSerailversionuid() {
        return serailVersionUID;
    }
}

