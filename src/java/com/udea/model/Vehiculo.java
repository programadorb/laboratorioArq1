
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
@Table(name="vehiculo")
@NamedQueries(@NamedQuery(name="Vehiculo.getAll",query="SELECT veh FROM Vehiculo veh"))
public class Vehiculo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String matricula;
    @Column
    private String marca;
    @Column
    private String Modelo;
    @Column
    private String Color;
    @Column
    private float Precio;
    @Column
    private byte[] foto;

    public Vehiculo(String Matricula, String Marca, String Modelo, String Color, float Precio, byte[] Foto) {
        this.matricula = Matricula;
        this.marca = Marca;
        this.Modelo = Modelo;
        this.Color = Color;
        this.Precio = Precio;
        this.foto = Foto;
    }

    public Vehiculo() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String Matricula) {
        this.matricula = Matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String Marca) {
        this.marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] Foto) {
        this.foto = Foto;
    }

    
    
    
    
}
