package com.udea.controller;
import com.udea.dao.ClienteDAOLocal;
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
public class clienteServlet extends HttpServlet {
    @EJB
    private ClienteDAOLocal clienteDAO;

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
        boolean buscarTodos= false;
        boolean controlMensaje = false;
        //Se toman las acciones de los botones del formulario cliente      
        String action = request.getParameter("action");
        //se capturan los datos del formulario cliente
         String cedulaStr = request.getParameter("cedula");
         String cedula = "";
            //Valida que el campo tenga algun dato
            if (cedulaStr != null && !cedulaStr.equals("")) 
            {
                cedula = cedulaStr;
            } 
        String nombre = request.getParameter("Nombre");        
        String apellido = request.getParameter("Apellido");
        String direccion = request.getParameter("Direccion");
        String telefono = request.getParameter("Telefono");
       
        //se invoca el constructor del POJO
        Cliente cliente = new Cliente(cedula, nombre, apellido, direccion,telefono);

        List<Cliente> c=null;
        //se invoca la accion de cada boton
        if ("Agregar".equalsIgnoreCase(action)) {
            try{
                clienteDAO.addCliente(cliente);
                mensaje= "El cliente se ha agregado exitosamente";
                controlMensaje = true;
            }catch(Exception e){
                mensaje="Error: Cédula inválida o ya existe en la base de datos";
                controlMensaje = true;
            };     
        } else if ("Editar".equalsIgnoreCase(action)) {   
            try{
            clienteDAO.editCliente(cliente);
             mensaje= "El cliente se ha editado exitosamente";
             controlMensaje = true;
            }catch(Exception e){
                mensaje="Error: No se pudo editar, el cliente no existe en la base de datos";
                controlMensaje = true;
            };     
        } else if ("Borrar".equalsIgnoreCase(action)) { 
            try{
            clienteDAO.deleteCliente(cedula);  
             mensaje= "El cliente se ha borrado exitosamente";
             controlMensaje = true;
            }catch(Exception e){
                 mensaje="Error: No se pudo borrar, el cliente no existe en la base de datos";
                 controlMensaje = true;
            };
        } else if ("Buscar".equalsIgnoreCase(action)) {
            
             try{
            cliente=clienteDAO.getCliente(cedula);
             //Se cargan los datos directamente del formulario
        request.setAttribute("message", cliente.getCedula()+"  ");
        request.setAttribute("message1", cliente.getNombre()+"  ");
        request.setAttribute("message2", cliente.getApellido()+"  ");
        request.setAttribute("message3", cliente.getDireccion()+"  ");
        request.setAttribute("message4", cliente.getTelefono()+"  "); 
        buscarTodos= false;
         //se redirecciona a la vista del cliente
        request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }catch(Exception e){
                mensaje="ERROR, No se pudo mostrar la información, el cliente no existe en la base de datos.";
                controlMensaje = true;
            };       
        }else if("BuscarTodos".equalsIgnoreCase(action)){
                    buscarTodos= true;
                    c =clienteDAO.getAllClientes();
        }
        //se definen los atributos para la carga de datos
        request.setAttribute("cliente", cliente);// solo se llama un objeto
        //se llama a clienteDAO.getAllClientes());
        request.setAttribute("allClientes", clienteDAO.getAllClientes());
        request.setAttribute("buscarTodo", buscarTodos); 
        request.setAttribute("mensaje", mensaje); 
        request.setAttribute("controlMensaje", controlMensaje);
        //redirecciona 
        request.getRequestDispatcher("/cliente.jsp").forward(request,response);   
  
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
