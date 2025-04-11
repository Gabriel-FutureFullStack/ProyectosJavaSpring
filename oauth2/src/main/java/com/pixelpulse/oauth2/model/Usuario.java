package com.pixelpulse.oauth2.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column
	@Id
	private String codUser;
	@Column(length = 8)
    private String dniCliente;
    @Column
    private String apellidosCliente;
    @Column
    private String nombresCliente;
    @Column
    private String domicilioLegal;
    @Column
    private String fechaNac;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String correo;
    @Column
    private Boolean estado;
    
    //Relaciones
    //Un usuario puede tener varios roles y un rol puede tener varios clientes
    
    
}
