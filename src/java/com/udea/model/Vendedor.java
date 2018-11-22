
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
@Table(name="vendedor")
@NamedQueries(@NamedQuery(name="Vendedor.getAll",query="SELECT v FROM Vendedor v"))
public class Vendedor implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String cedula;
    @Column
    private String Nombre;
    @Column
    private String Apellido;

    public Vendedor(String Cedula, String Nombre, String Apellido) {
        this.cedula = Cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    public Vendedor() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String Cedula) {
        this.cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
   
    
}
