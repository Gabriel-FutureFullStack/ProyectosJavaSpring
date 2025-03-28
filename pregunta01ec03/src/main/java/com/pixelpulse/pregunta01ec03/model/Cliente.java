package com.pixelpulse.pregunta01ec03.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
    //Atributos del Cliente
    private static final long serialVersionUID = 1L;
    @Id
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
    //Un cliente puede tener varios roles y un rol puede tener varios clientes
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "cliente_rol",
        joinColumns = @JoinColumn(name = "dni_Cliente", nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(dni_cliente) references cliente(dni_Cliente)")),
            inverseJoinColumns = @JoinColumn(name = "id_rol", nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_rol) references rol(id_rol)"))
    )
    @JsonIgnore
    private Set<Rol> itemsRol = new HashSet<>();

    // Relación con Prestamo
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Collection<Prestamo> itemsPrestamo = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(String dniCliente, String apellidosCliente, String nombresCliente, String domicilioLegal,
            String fechaNac, String username, String password, Boolean estado, Set<Rol> itemsRol) {
        this.dniCliente = dniCliente;
        this.apellidosCliente = apellidosCliente;
        this.nombresCliente = nombresCliente;
        this.domicilioLegal = domicilioLegal;
        this.fechaNac = fechaNac;
        this.username = username;
        this.password = password;
        this.estado = estado;
        this.itemsRol = itemsRol;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getApellidosCliente() {
        return apellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

    public String getNombresCliente() {
        return nombresCliente;
    }

    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    public String getDomicilioLegal() {
        return domicilioLegal;
    }

    public void setDomicilioLegal(String domicilioLegal) {
        this.domicilioLegal = domicilioLegal;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean isEstado() {
        return estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Set<Rol> getItemsRol() {
        return itemsRol;
    }
    public void setItemsRol(Set<Rol> itemsRol) {
        this.itemsRol = itemsRol;
    }

    public void agregarRoleALista(Rol rol){
        this.itemsRol.add(rol);
    }

    public Collection<Prestamo> getItemsPrestamo() {
        return itemsPrestamo;
    }

    public void setItemsPrestamo(Collection<Prestamo> itemsPrestamo) {
        this.itemsPrestamo = itemsPrestamo;
    }

}
