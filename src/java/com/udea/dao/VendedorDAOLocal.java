
package com.udea.dao;

import com.udea.model.Vendedor;
import java.util.List;
import javax.ejb.Local;


@Local
public interface VendedorDAOLocal {
     void addVendedor(Vendedor ven);
    
    void editVendedor(Vendedor ven);
    
    void deleteVendedor(String venID);
    
    Vendedor getVendedor(String venID);
    
    List<Vendedor> getAllVendedores();
    
}
