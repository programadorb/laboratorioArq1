package com.udea.controller;

import com.udea.dao.VehiculoDAOLocal;
import com.udea.model.Vehiculo;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.out;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@MultipartConfig(maxFileSize = 16177215)
@WebServlet(name = "VehiculoServlet", urlPatterns = {"/VehiculoServlet"})
public class vehiculoServlet extends HttpServlet {

    @EJB
    private VehiculoDAOLocal vehiculoDAO;

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
        String mensaje = "";
        String codigo = request.getParameter("code"); //permite saber si se requiere texto !=1 o imagen ==1
        String vehmatricula = request.getParameter("matricula"); //Buscar el vehiculo para obtener su foto
        byte[] data = null;
        List<Vehiculo> listaVehiculos = vehiculoDAO.getAllVehiculos(); //Obtiene todos los vehiculos en la BD

        //Busca el vehículo requerido
        for (Vehiculo car : listaVehiculos) {
            String mat = car.getMatricula();
            if (mat.equalsIgnoreCase(vehmatricula)) {
                data = car.getFoto();
            }
        }
        //Envía la imagen a la vista del vehículo
        if (codigo != null && "1".equalsIgnoreCase(codigo)) {
            response.setContentType("image/jpeg");
            response.getOutputStream().write(data);
            response.getOutputStream().close();
        } else {
            response.setContentType("text/html;charset=UTF-8");
        }
        //Se toman las acciones de los botones del formulario Vehículo    
        String action = request.getParameter("action");

        //se captura la matricula del formulario
        String matriculaStr = request.getParameter("matricula");
        String matricula = "";
        //Valida que el campo tenga algún dato
        if (matriculaStr != null && !matriculaStr.equals("")) {
            matricula = matriculaStr;
        }

        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String color = request.getParameter("color");
        String preciostr = request.getParameter("precio");
        float precio = 0;
        //Valida que el campo precio tenga algun dato
        if (preciostr != null && !preciostr.equals("")) {
            precio = Float.parseFloat(preciostr);//convierte cadena de caracteres a float
        }
       InputStream inputStream;
        //Obtiene la parte del archivo a cargar en la peticion (multipart)
        Part filePart = request.getPart("foto");
        byte[] foto = null;
        //valida que no esté vacio el archivo
        if (filePart != null) {
            //Obtiene el input stream del archivo cargado y lo almacena como un arreglo de bytes
            inputStream = filePart.getInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int longitud = 0; (longitud = inputStream.read(buffer)) > 0;) {
                output.write(buffer, 0, longitud);
            }
            foto = output.toByteArray();
        }
        
        //se invoca el constructor del POJO
       Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, color, precio, foto);

        List<Vehiculo> v;
        //se invoca la acción de cada botón
        if ("Agregar".equalsIgnoreCase(action)) {
            try {
                vehiculoDAO.addVehiculo(vehiculo);
                 mensaje= "El vehículo se ha agregado exitosamente";
                 controlMensaje = true;
            } catch (Exception e) {
                mensaje = "Error: Matrícula inválida o ya existe en la base de datos";
                controlMensaje = true;
            };
        } else if ("Editar".equalsIgnoreCase(action)) {
            try {
                vehiculoDAO.editVehiculo(vehiculo);
                mensaje= "El vehículo se ha editado exitosamente";
                controlMensaje = true;
            } catch (Exception e) {
                mensaje = "Error: No se pudo editar, la matricula no existe en la base de datos";
                controlMensaje = true;                

            };
        } else if ("Borrar".equalsIgnoreCase(action)) {
            try {
                vehiculoDAO.deleteVehiculo(matricula);
                mensaje= "El vehículo se ha borrado exitosamente";
                controlMensaje = true;
            } catch (Exception e) {
                mensaje = "Error: No se pudo borrar, la matricula no existe en la base de datos";
                controlMensaje = true;
            };
        } else if ("Buscar".equalsIgnoreCase(action)) {
            try {
                vehiculo = vehiculoDAO.getVehiculo(matricula);
                //Se cargan los datos directamente del formulario
                request.setAttribute("message", vehiculo.getMatricula() + "  ");
                request.setAttribute("message1", vehiculo.getMarca() + "  ");
                request.setAttribute("message2", vehiculo.getModelo() + "  ");
                request.setAttribute("message3", vehiculo.getColor() + "  ");
                request.setAttribute("message4", vehiculo.getPrecio() + "  ");
                buscarTodo=false;
                //se redirecciona a la vista del vehiculo
                request.getRequestDispatcher("vehiculo.jsp").forward(request, response);
            } catch (Exception e) {
                mensaje = "ERROR, No se pudo mostrar la información, el vehículo no existe en la base de datos";
                controlMensaje = true;
            };
        } else if ("BuscarTodos".equalsIgnoreCase(action)) {
            buscarTodo= true;
            v = vehiculoDAO.getAllVehiculos();
        }
        //se definen los atributos para la carga de datos
        request.setAttribute("vehiculo", vehiculo);// solo se llama un objeto
        //se llama todos los objetos retornados para la tabla HTML
        request.setAttribute("allVehiculos", vehiculoDAO.getAllVehiculos());
        request.setAttribute("mensaje", mensaje);
        request.setAttribute("buscarTodo", buscarTodo);
        request.setAttribute("controlMensaje", controlMensaje);
        //redirecciona 
        request.getRequestDispatcher("/vehiculo.jsp").forward(request, response);
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
