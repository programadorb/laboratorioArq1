/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.dao;

import com.udea.model.Cliente;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ClienteDAOLocal {

    void addCliente(Cliente cliente);

    void editCliente(Cliente cliente);

    void deleteCliente(String clienteID);

    Cliente getCliente(String clienteID);

    List<Cliente> getAllClientes();
     
   
    
    
    
}
