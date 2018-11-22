
package com.udea.dao;

import com.udea.model.Ventas_generales;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class VentasDAO implements VentasDAOLocal {

    @PersistenceContext
    private EntityManager em;
    
   @Override
    public void addVenta(Ventas_generales venta) {
        em.persist(venta);
    }

    @Override
    public void editVenta(Ventas_generales venta) {
        em.merge(venta);
    }

    @Override
    public void deleteVenta(String ventaID) {
        em.remove(getVenta(ventaID));
    }

    @Override
    public Ventas_generales getVenta(String ventaID) {
        return em.find(Ventas_generales.class, ventaID);
    }

    @Override
    public List<Ventas_generales> getAllVentas() {
        return em.createNamedQuery("Ventas.getAll").getResultList();
    }
}
