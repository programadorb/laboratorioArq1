package com.udea.dao;

import com.udea.model.Venta;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class VentasDAO {

    @PersistenceContext
    private EntityManager em;
    
    public void addVenta(Venta venta) {
        em.persist(venta);
    }

    public void editVenta(Venta venta) {
        em.merge(venta);
    }

    public void deleteVenta(String ventaID) {
        em.remove(getVenta(ventaID));
    }
    
    public Venta getVenta(String ventaID) {
        return em.find(Venta.class, ventaID);
    }
    
    public List<Venta> getAllVentas() {
        return em.createNamedQuery("Ventas.getAll").getResultList();
    }
}