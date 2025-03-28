package com.pixelpulse.lasolucion.model;

import java.io.Serializable;

public class Amortizacion implements Serializable {
	
	private Long numPrestamo;
	private String fechPrestamo;
	private int numAmortizacion;
	private String dni;
	private double impCapital;
	private double impInteres;
	private double impTAmortizado;
	
	private static final long serailVersionUID = 1L;
	
	private static long idCounter = 1;
	
	public Amortizacion() {
        this.numAmortizacion = (int) idCounter++; 
    }

	public Amortizacion(Long numPrestamo, String fechPrestamo, int numAmortizacion, String dni, double impCapital,
			double impInteres, double impTAmortizado) {
		super();
		this.numPrestamo = numPrestamo;
		this.fechPrestamo = fechPrestamo;
		this.numAmortizacion = numAmortizacion;
		this.dni = dni;
		this.impCapital = impCapital;
		this.impInteres = impInteres;
		this.impTAmortizado = impTAmortizado;
	}

	public Long getNumPrestamo() {
		return numPrestamo;
	}

	public void setNumPrestamo(Long numPrestamo) {
		this.numPrestamo = numPrestamo;
	}

	public String getFechPrestamo() {
		return fechPrestamo;
	}

	public void setFechPrestamo(String fechPrestamo) {
		this.fechPrestamo = fechPrestamo;
	}

	public int getNumAmortizacion() {
		return numAmortizacion;
	}

	public void setNumAmortizacion(int numAmortizacion) {
		this.numAmortizacion = numAmortizacion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getImpCapital() {
		return impCapital;
	}

	public void setImpCapital(double impCapital) {
		this.impCapital = impCapital;
	}

	public double getImpInteres() {
		return impInteres;
	}

	public void setImpInteres(double impInteres) {
		this.impInteres = impInteres;
	}

	public double getImpTAmortizado() {
		return impTAmortizado;
	}

	public void setImpTAmortizado(double impTAmortizado) {
		this.impTAmortizado = impTAmortizado;
	}
	
	
	
}
