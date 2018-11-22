
package com.udea.dao;

import com.udea.model.Vendedor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class VendedorDAO implements VendedorDAOLocal {

    @PersistenceContext
    private EntityManager em;
        
   @Override
    public void addVendedor(Vendedor ven) {
        em.persist(ven);
       
    }

    @Override
    public void editVendedor(Vendedor ven) {
        em.merge(ven);
    }

    @Override
    public void deleteVendedor(String venID) {
        em.remove(getVendedor(venID));
    }

    @Override
    public Vendedor getVendedor(String venID) {
        return em.find(Vendedor.class, venID);
    }

    @Override
    public List<Vendedor> getAllVendedores() {
        return em.createNamedQuery("Vendedor.getAll").getResultList();
    }
}
