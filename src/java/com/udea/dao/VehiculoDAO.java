
package com.udea.dao;

import com.udea.model.Vehiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class VehiculoDAO implements VehiculoDAOLocal {

    @PersistenceContext
    private EntityManager em;
    
   @Override
    public void addVehiculo(Vehiculo veh) {
        em.persist(veh);      
    }

    @Override
    public void editVehiculo(Vehiculo veh) {
        em.merge(veh);
    }

    @Override
    public void deleteVehiculo(String vehID) {
        em.remove(getVehiculo(vehID));
    }

    @Override
    public Vehiculo getVehiculo(String vehID) {
        return em.find(Vehiculo.class, vehID);
    }

    @Override
    public List<Vehiculo> getAllVehiculos() {
        return em.createNamedQuery("Vehiculo.getAll").getResultList();

    }
}
