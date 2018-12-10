package com.udea.dao;

import com.udea.model.Vehiculo;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class VehiculoDAO {

    @PersistenceContext
    private EntityManager em;
    
    public void addVehiculo(Vehiculo veh) {
        em.persist(veh);      
    }

    public void editVehiculo(Vehiculo veh) {
        em.merge(veh);
    }

    public void deleteVehiculo(String vehID) {
        em.remove(getVehiculo(vehID));
    }

    public Vehiculo getVehiculo(String vehID) {
        return em.find(Vehiculo.class, vehID);
    }

    public List<Vehiculo> getAllVehiculos() {
        return em.createNamedQuery("Vehiculo.getAll").getResultList();

    }
}