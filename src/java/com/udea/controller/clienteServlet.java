package com.udea.controller;
import com.udea.dao.ClienteDAO;
import com.udea.model.Cliente;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {
    @EJB
    private ClienteDAO clienteDAO;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mensaje="";
        
        String action = request.getParameter("action");
         String cedulaStr = request.getParameter("cedula");
         String cedula = "";
        if (cedulaStr != null && !cedulaStr.equals("")) 
        {
            cedula = cedulaStr;
        } 
        String nombre = request.getParameter("Nombre");        
        String apellido = request.getParameter("Apellido");
        String direccion = request.getParameter("Direccion");
        String telefono = request.getParameter("Telefono");
       
        //se invoca el constructor del POJO
        Cliente cliente = new Cliente();
        cliente.setApellido(apellido);
        cliente.setCedula(cedula);
        cliente.setDireccion(direccion);
        cliente.setTelefono(telefono);

        List<Cliente> c=null;
        
        if ("Agregar".equalsIgnoreCase(action)) {
            clienteDAO.addCliente(cliente);
            mensaje= "El cliente se ha agregado exitosamente";
        } else if ("Editar".equalsIgnoreCase(action)) {   
            clienteDAO.editCliente(cliente);
            mensaje= "El cliente se ha editado exitosamente";
        } else if ("Borrar".equalsIgnoreCase(action)) { 
            clienteDAO.deleteCliente(cedula);  
            mensaje= "El cliente se ha borrado exitosamente";    
        } else if ("Buscar".equalsIgnoreCase(action)) {
            cliente=clienteDAO.getCliente(cedula);
            request.setAttribute("message", cliente.getCedula()+"  ");
            request.setAttribute("message1", cliente.getNombre()+"  ");
            request.setAttribute("message2", cliente.getApellido()+"  ");
            request.setAttribute("message3", cliente.getDireccion()+"  ");
            request.setAttribute("message4", cliente.getTelefono()+"  "); 
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }

        c =clienteDAO.getAllClientes();
        
        request.setAttribute("cliente", cliente);// solo se llama un objeto
        request.setAttribute("allClientes", clienteDAO.getAllClientes());
        request.setAttribute("mensaje", mensaje); 
        request.getRequestDispatcher("/cliente.jsp").forward(request,response);   
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
