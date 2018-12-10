
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
@NamedQueries(@NamedQuery(name="Vehiculo.getAll",query="SELECT veh FROM Vehiculo veh"))
public class Vehiculo implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    private String matricula;
    
    @Column
    private String marca;
    
    @Column
    private String modelo;
    
    @Column
    private String color;
    
    @Column
    private float precio;
    
    @Column
    private String foto;    
    
    public Vehiculo(){}

    public void setMatricula(String matricula){this.matricula=matricula;}
    public String getMatricula(){return this.matricula;}


    public void setMarca(String marca){this.marca=marca;}
    public String getMarca(){return this.marca;}


    public void setModelo(String modelo){this.modelo=modelo;}
    public String getModelo(){return this.modelo;}


    public void setColor(String color){this.color=color;}
    public String getColor(){return this.color;}


    public void setPrecio(float precio){this.precio=precio;}
    public float getPrecio(){return this.precio;}


    public void setFoto(String foto){this.foto=foto;}
    public String getFoto(){return this.foto;}

}
