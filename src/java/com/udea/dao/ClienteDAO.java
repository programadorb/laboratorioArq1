
package com.udea.dao;

import com.udea.model.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class ClienteDAO {

    @PersistenceContext
    private EntityManager em;

    public void addCliente(Cliente cliente) {
       em.persist(cliente);
    }

    public void editCliente(Cliente cliente) {
        em.merge(cliente);
    }

    public void deleteCliente(String clienteID) {
        em.remove(getCliente(clienteID));
    }

    public Cliente getCliente(String clienteID) {
        return em.find(Cliente.class, clienteID);
    }

    public List<Cliente> getAllClientes() {
        return em.createNamedQuery("Cliente.getAll").getResultList();
    }
}
