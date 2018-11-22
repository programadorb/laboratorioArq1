
package com.udea.dao;

import com.udea.model.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ClienteDAO implements ClienteDAOLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addCliente(Cliente cliente) {
       em.persist(cliente);
    }

    @Override
    public void editCliente(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    public void deleteCliente(String clienteID) {
        em.remove(getCliente(clienteID));
    }

    @Override
    public Cliente getCliente(String clienteID) {
        return em.find(Cliente.class, clienteID);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return em.createNamedQuery("Cliente.getAll").getResultList();
    }
    
   
    
   
    
   
    

    
    
   

   
}
