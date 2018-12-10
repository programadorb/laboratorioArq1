/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.dao.VentasDAO;
import com.udea.model.Venta;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "VentasServlet", urlPatterns = {"/VentasServlet"})
public class VentasServlet extends HttpServlet {
    @EJB
    private VentasDAO ventasDAO;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String mensaje="";
        //Se toman las acciones de los botones del formulario ventas    
        String action = request.getParameter("action");
        //se capturan los datos del formulario ventas
         String codStr = request.getParameter("codigo");
         String cod = "";
            //Valida que el campo tenga algun dato
            if (codStr != null && !codStr.equals("")) 
            {
                cod = codStr;
            } 
        String cliente = request.getParameter("cliente");        
        String vehiculo = request.getParameter("vehiculo");
        String vendedor = request.getParameter("vendedor");
        String preciostr = request.getParameter("valor_total");
        
         float precio = 0;
            //Valida que el campo precio tenga algun dato
            if (preciostr != null && !preciostr.equals("")) 
            {
                precio = Float.parseFloat(preciostr);//convierte cadena de caracteres a float
            } 
       
        //se invoca el constructor del POJO
        Venta ventas= new Venta();
        ventas.setCodigo(cod);
        ventas.setCliente(cliente);
        ventas.setVehiculo(vehiculo);
        ventas.setValor(precio);
        
        List<Venta> v;
        //se invoca la accion de cada boton
        if ("Agregar".equalsIgnoreCase(action)) {
            ventasDAO.addVenta(ventas);
            mensaje= "La venta se ha agregado exitosamente";
        } else if ("Editar".equalsIgnoreCase(action)) { 
            ventasDAO.editVenta(ventas);
            mensaje= "La venta se ha agregado exitosamente";
        } else if ("Borrar".equalsIgnoreCase(action)) { 
            ventasDAO.deleteVenta(cod);   
            mensaje= "La venta se ha agregado exitosamente";
        } else if ("Buscar".equalsIgnoreCase(action)) {
            ventas=ventasDAO.getVenta(cod);
            request.setAttribute("message", ventas.getCodigo()+"  ");
            request.setAttribute("message1", ventas.getCliente()+"  ");
            request.setAttribute("message2", ventas.getVehiculo()+"  ");
            request.setAttribute("message4", ventas.getValor()+"  ");
        }
        v = ventasDAO.getAllVentas();
        //se definen los atributos para la carga de datos
        request.setAttribute("ventas", ventas);// solo se llama un objeto
        //se llama todos los objetos retornados para la tabla HTML
        request.setAttribute("allVentas", ventasDAO.getAllVentas());
        request.setAttribute("mensaje", mensaje);
        //redirecciona 
        request.getRequestDispatcher("/venta.jsp").forward(request,response);   
  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
