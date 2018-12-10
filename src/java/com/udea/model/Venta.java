package com.udea.model;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries(@NamedQuery(name="Ventas.getAll",query="SELECT ven FROM Venta ven"))
public class Venta implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    private String codigo;
    
    @Column
    private String cliente;
    
    @Column
    private String vehiculo;
    
    @Column
    private float valor;

    public Venta() {}

    public void setCodigo(String codigo){this.codigo=codigo;}
    public String getCodigo(){return this.codigo;}


    public void setCliente(String cliente){this.cliente=cliente;}
    public String getCliente(){return this.cliente;}


    public void setVehiculo(String vehiculo){this.vehiculo=vehiculo;}
    public String getVehiculo(){return this.vehiculo;}


    public void setValor(float valor){this.valor=valor;}
    public float getValor(){return this.valor;}

}
