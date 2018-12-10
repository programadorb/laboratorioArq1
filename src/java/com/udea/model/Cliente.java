package com.udea.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(@NamedQuery(name="Cliente.getAll",query="SELECT c FROM Cliente c"))
public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column 
    private String cedula;
    
    @Column 
    private String nombre;
    
    @Column 
    private String apellido;
    
    @Column 
    private String direccion;
    
    @Column 
    private String telefono;

    public Cliente() {}

    public void setCedula(String cedula){this.cedula=cedula;}
    public String getCedula(){return this.cedula;}


    public void setNombre(String nombre){this.nombre=nombre;}
    public String getNombre(){return this.nombre;}


    public void setApellido(String apellido){this.apellido=apellido;}
    public String getApellido(){return this.apellido;}


    public void setDireccion(String direccion){this.direccion=direccion;}
    public String getDireccion(){return this.direccion;}


    public void setTelefono(String telefono){this.telefono=telefono;}
    public String getTelefono(){return this.telefono;}

}
   