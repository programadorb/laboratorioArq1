
package com.udea.dao;

import com.udea.model.Ventas_generales;
import java.util.List;
import javax.ejb.Local;


@Local
public interface VentasDAOLocal {
    
    void addVenta(Ventas_generales venta);
    
    void editVenta(Ventas_generales venta);
    
    void deleteVenta(String ventaID);
    
    Ventas_generales getVenta(String ventaID);
    
    List<Ventas_generales> getAllVentas();
}
