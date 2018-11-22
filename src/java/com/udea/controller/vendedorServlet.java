package com.udea.controller;
import com.udea.dao.VendedorDAOLocal;
import com.udea.model.Vendedor;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VendedorServlet", urlPatterns = {"/VendedorServlet"})
public class vendedorServlet extends HttpServlet {
    @EJB
    private VendedorDAOLocal vendedorDAO;

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
        
        boolean buscarTodo=false;
        boolean controlMensaje = false;
        String mensaje="";
        //Se toman las acciones de los botones del formulario vendedor    
        String action = request.getParameter("action");
        //se capturan los datos del formulario vendedor
         String cedulaStr = request.getParameter("cedula");
         String cedula = "";
            //Valida que el campo tenga algun dato
            if (cedulaStr != null && !cedulaStr.equals("")) 
            {
                cedula = cedulaStr;
            } 
        String nombre = request.getParameter("nombre");        
        String apellido = request.getParameter("apellido");
       
        //se invoca el constructor del POJO
        Vendedor vendedor= new Vendedor(cedula, nombre, apellido);

        List<Vendedor> v;
        //se invoca la accion de cada boton
        if ("Agregar".equalsIgnoreCase(action)) { 
             try{
                 vendedorDAO.addVendedor(vendedor);
                 mensaje= "El vendedor se ha agregado exitosamente";
                 controlMensaje = true;
            }catch(Exception e){
                mensaje="Error, Cédula inválida o ya existe en la base de datos";
                controlMensaje = true;
            };          
        } else if ("Editar".equalsIgnoreCase(action)) { 
             try{
                vendedorDAO.editVendedor(vendedor);
                mensaje= "El vendedor se ha editado exitosamente";
                controlMensaje = true;
            }catch(Exception e){
                mensaje="Error, No se pudo editar, el vendedor no existe en la base de datos";
                controlMensaje = true;
            }; 
            
        } else if ("Borrar".equalsIgnoreCase(action)) { 
            try{
            vendedorDAO.deleteVendedor(cedula);   
            mensaje= "El vendedor se ha borrado exitosamente";
            controlMensaje = true;
            }catch(Exception e){
                 mensaje="Error, No se pudo borrar, el vendedor no existe en la base de datos";
            };
            
        } else if ("Buscar".equalsIgnoreCase(action)) {
              try{
             vendedor=vendedorDAO.getVendedor(cedula);
             //Se cargan los datos directamente del formulario
        request.setAttribute("message", vendedor.getCedula()+"  ");
        request.setAttribute("message1", vendedor.getNombre()+"  ");
        request.setAttribute("message2", vendedor.getApellido()+"  ");
        buscarTodo= false;
        //se redirecciona a la vista del vendedor
        request.getRequestDispatcher("vendedor.jsp").forward(request, response);
            }catch(Exception e){
                mensaje="Error, No se pudo mostrar la información, el vendedor no existe en la base de datos";
                controlMensaje = true;
            };    
        
        }else if("BuscarTodos".equalsIgnoreCase(action)){
            buscarTodo= true;
            v =vendedorDAO.getAllVendedores();
        }
        //se definen los atributos para la carga de datos
        request.setAttribute("vendedor", vendedor);// solo se llama un objeto
        //se llama todos los objetos retornados para la tabla HTML
        request.setAttribute("allVendedor", vendedorDAO.getAllVendedores());
        request.setAttribute("mensaje", mensaje);
        request.setAttribute("buscarTodo", buscarTodo);
        request.setAttribute("controlMensaje", controlMensaje);
        //redirecciona 
        request.getRequestDispatcher("/vendedor.jsp").forward(request,response);   
  
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
