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
@NamedQueries(@NamedQuery(name="Ventas.getAll",query="SELECT ven FROM Ventas_generales ven"))
public class Ventas_generales implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String codigo_venta;
    @Column
    private String Cliente;
    @Column
    private String Vehiculo;
    @Column
    private String Vendedor;
    @Column
    private float valor_total;

    public Ventas_generales(String Codigo_venta, String Cliente, String Vehiculo, String Vendedor, float Valor_total) {
        this.codigo_venta = Codigo_venta;
        this.Cliente = Cliente;
        this.Vehiculo = Vehiculo;
        this.Vendedor = Vendedor;
        this.valor_total = Valor_total;
    }

    public Ventas_generales() {
    }

    public String getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(String Codigo_venta) {
        this.codigo_venta = Codigo_venta;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getVehiculo() {
        return Vehiculo;
    }

    public void setVehiculo(String Vehiculo) {
        this.Vehiculo = Vehiculo;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float Valor_total) {
        this.valor_total = Valor_total;
    }

  
    
    
}
