
package com.udea.dao;

import com.udea.model.Vehiculo;
import java.util.List;
import javax.ejb.Local;


@Local
public interface VehiculoDAOLocal {
    
    void addVehiculo(Vehiculo veh);
    
    void editVehiculo(Vehiculo veh);
    
    void deleteVehiculo(String vehID);
    
    Vehiculo getVehiculo(String vehID);
    
    List<Vehiculo> getAllVehiculos();
    
}
